package com.rapis.service.impl;

import com.rapis.dao.UserMapper;
import com.rapis.entity.User;
import com.rapis.service.UserService;
import com.rapis.util.CodeMsg;
import com.rapis.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author siboran
 * @create 2022/2/16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Result<String> Register(User user) {
        if(userMapper.getUserByName(user.getUsername())!=null)
            return Result.result(CodeMsg.REGISTER_NAME_EXIST);
        userMapper.insertUser(user);
        return Result.result(CodeMsg.REGISTER_SUCCESS);
    }

    @Override
    public Result<String> Login(User user) {
        User dbUser =userMapper.getUserByName(user.getUsername());
        if(dbUser==null)
            return Result.result(CodeMsg.LOGIN_NAME_NOTEXIST);
        else if(!dbUser.getPassword().equals(user.getPassword()))
            return Result.result(CodeMsg.LOGIN_PASSWORD_INCORRECT);
        else
            return Result.result(CodeMsg.LOGIN_SUCCESS);
    }
}
