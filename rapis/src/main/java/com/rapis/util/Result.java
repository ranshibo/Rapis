package com.rapis.util;

import lombok.Data;

/**
 * @author siboran
 * @create 2022/2/16
 */
@Data
public final class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(CodeMsg codeMsg, T data) {
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    public static <T> Result<T> result(CodeMsg codeMsg, T data) {
        return new Result<T>(codeMsg, data);
    }

    public static <T> Result<T> result(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }
}

