package com.rapis.service;

import com.rapis.entity.User;
import com.rapis.util.Result;
import org.springframework.stereotype.Service;

/**
 * @author siboran
 * @create 2022/2/16
 */


public interface UserService {
    Result<String> Register(User user);
    Result<String> Login(User user);
}
