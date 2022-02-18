package com.rapis.util;

import lombok.Getter;

/**
 * @author siboran
 * @create 2022/2/16
 */
@Getter
public enum CodeMsg {

    UTIL_SUCCESS(0, "success"),
    UTIL_ERROR(1, "error"),
    REGISTER_SUCCESS(100001, "注册成功"),
    REGISTER_NAME_EXIST(100002, "该用户名已被注册"),
    LOGIN_SUCCESS(100003, "登陆成功"),
    LOGIN_NAME_NOTEXIST(100004, "该用户名未注册"),
    LOGIN_INCORRECT(100005, "用户名、密码或验证码错误"),
    INPUT_BLANK(100006, "用户名、密码或验证码不能为空"),
    LOGIN_NOT(100007, "用户未登录");
    private int code;
    private String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
