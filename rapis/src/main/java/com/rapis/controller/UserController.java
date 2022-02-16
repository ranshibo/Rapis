package com.rapis.controller;

import com.rapis.entity.User;
import com.rapis.service.UserService;
import com.rapis.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author siboran
 * @create 2022/2/16
 */

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Result<String>> regiseter(@RequestBody User user){
        return ResponseEntity.ok(userService.Register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Result<String>> login(@RequestBody User user){
        return ResponseEntity.ok(userService.Login(user));
    }
}
