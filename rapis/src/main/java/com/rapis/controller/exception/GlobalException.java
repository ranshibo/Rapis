package com.rapis.controller.exception;

import com.rapis.util.CodeMsg;

/**
 * @author siboran
 * @create 2022/2/18
 */
public class GlobalException extends RuntimeException {
    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
