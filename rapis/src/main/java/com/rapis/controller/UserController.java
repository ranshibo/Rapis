package com.rapis.controller;

import com.rapis.entity.User;
import com.rapis.service.UserService;
import com.rapis.util.CodeMsg;
import com.rapis.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author siboran
 * @create 2022/2/16
 */

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Result<String>> regiseter(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.Register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Result<String>> login(@RequestBody User user, HttpServletResponse httpServletResponse) {
        logger.info("新的登陆请求："+user.getUsername());
        return ResponseEntity.ok(userService.Login(user, httpServletResponse));
    }

    @GetMapping("/logout")
    public ResponseEntity<Result<String>> logout( HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(userService.logout(httpServletRequest));
    }

    @GetMapping("/login")
    public ResponseEntity<Result<String>> getuser(HttpServletRequest httpServletRequest) throws Exception {
       return ResponseEntity.ok(Result.result(CodeMsg.UTIL_SUCCESS,userService.getUser(httpServletRequest)));
    }
}
