package com.rapis.util;

/**
 * @author siboran
 * @create 2022/2/16
 */
public class CodeMsg {
    private int code;
    private String msg;

    public static CodeMsg UTIL_SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg UTIL_ERROR = new CodeMsg(1, "error");
    //user msg
    public static CodeMsg REGISTER_SUCCESS = new CodeMsg(100001, "注册成功");
    public static CodeMsg REGISTER_NAME_EXIST = new CodeMsg(100002, "该用户名已被注册");
    public static CodeMsg LOGIN_SUCCESS = new CodeMsg(100003, "登陆成功");
    public static CodeMsg LOGIN_NAME_NOTEXIST = new CodeMsg(100004, "该用户名未注册");
    public static CodeMsg LOGIN_PASSWORD_INCORRECT = new CodeMsg(100005, "密码错误");
    public static CodeMsg INPUT_BLANK = new CodeMsg(100006, "用户名、密码或验证码不能为空");
    public static CodeMsg LOGIN_NOT = new CodeMsg(100007, "用户未登录");
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static CodeMsg getUtilSuccess() {
        return UTIL_SUCCESS;
    }

    public static void setUtilSuccess(CodeMsg utilSuccess) {
        UTIL_SUCCESS = utilSuccess;
    }

    public static CodeMsg getUtilError() {
        return UTIL_ERROR;
    }

    public static void setUtilError(CodeMsg utilError) {
        UTIL_ERROR = utilError;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
