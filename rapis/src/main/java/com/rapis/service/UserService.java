package com.rapis.service;

import com.rapis.entity.User;
import com.rapis.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author siboran
 * @create 2022/2/16
 */


public interface UserService {
    Result<String> Register(User user);
    Result<String> Login(User user, HttpServletResponse httpServletResponse);
    Result<String> getUser(HttpServletRequest httpServletRequest);
}
