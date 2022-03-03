package com.rapis.service.impl;

import com.rapis.controller.exception.GlobalException;
import com.rapis.dao.UserMapper;
import com.rapis.entity.User;
import com.rapis.service.UserService;
import com.rapis.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

/**
 * @author siboran
 * @create 2022/2/16
 */
@Service
public class UserServiceImpl implements UserService {
    private final static int EXPRIE_TIME = 60 * 60 * 24;
    private final static String cookieTokenName = "token";
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public Result<String> Register(User user) throws Exception {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            return Result.result(CodeMsg.INPUT_BLANK);
        if (userMapper.getUserByName(user.getUsername()) != null)
            return Result.result(CodeMsg.REGISTER_NAME_EXIST);
        String salt = CommonUtil.getUUID().substring(0,8);
        user.setSalt(salt);
        user.setPassword(CommonUtil.md5(salt+user.getPassword()));
        user.setType(0);
        user.setStatus(0);
        DbUtil.addCreateInfo(user,DbUtil.ADMIN);
        userMapper.insertUser(user);
        return Result.result(CodeMsg.REGISTER_SUCCESS);
    }

    @Override
    public Result<String> Login(User user, HttpServletResponse httpServletResponse) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            return Result.result(CodeMsg.INPUT_BLANK);
        User dbUser = userMapper.getUserByName(user.getUsername());
        if (dbUser == null)
            return Result.result(CodeMsg.LOGIN_NAME_NOTEXIST);
        if (!dbUser.getPassword().equals(CommonUtil.md5(dbUser.getSalt()+user.getPassword())))
            return Result.result(CodeMsg.LOGIN_INCORRECT);
        String token = CommonUtil.getUUID();
        String redisKey = RedisKeyUtil.getTOKENKey(token);
        redisTemplate.opsForValue().set(redisKey, user.getUsername(), EXPRIE_TIME, TimeUnit.SECONDS);
        Cookie cookie = new Cookie(cookieTokenName, token);
        cookie.setMaxAge(EXPRIE_TIME);
        httpServletResponse.addCookie(cookie);
        return Result.result(CodeMsg.LOGIN_SUCCESS,token);
    }

    @Override
    public Result<String> logout(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if (cookieTokenName.equals(cookie.getName())) {
                String redisKey = RedisKeyUtil.getTOKENKey(cookie.getValue());
                redisTemplate.delete(redisKey);
                return Result.result(CodeMsg.LOGOUT_SUCCESS);
            }
        }
        return Result.result(CodeMsg.LOGIN_NOT);
    }

    @Override
    public String getUser(HttpServletRequest httpServletRequest) throws GlobalException {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null || cookies.length <= 0)
            throw new GlobalException(CodeMsg.LOGIN_NOT);
        for (Cookie cookie : cookies) {
            if (cookieTokenName.equals(cookie.getName())) {
                String redisKey = RedisKeyUtil.getTOKENKey(cookie.getValue());
                if (redisTemplate.hasKey(redisKey) != null && redisTemplate.getExpire(redisKey) > 0)
                    return redisTemplate.opsForValue().get(redisKey).toString();
            }
        }
        throw new GlobalException(CodeMsg.LOGIN_NOT);
    }
}
