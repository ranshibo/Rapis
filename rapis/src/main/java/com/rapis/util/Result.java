package com.rapis.util;/**
*@author siboran
*@create 2022/2/16
*/
public class Result<T> {
    private CodeMsg codeMsg;
    private T data;

    private Result(CodeMsg codeMsg,T data) {
        this.codeMsg=codeMsg;
        this.data = data;
    }
    private Result(CodeMsg codeMsg) {
        this.codeMsg=codeMsg;
    }

    public static <T> Result<T> result(CodeMsg codeMsg,T data) {
        return new Result<T>(codeMsg,data);
    }
    public static <T> Result<T> result(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "codeMsg=" + codeMsg +
                ", data=" + data +
                '}';
    }
}

