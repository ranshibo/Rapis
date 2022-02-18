package com.rapis.controller.exception;

import com.rapis.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author siboran
 * @create 2022/2/18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    @ResponseBody
    public Result<String> handleException(GlobalException e) {
        return Result.result(e.getCodeMsg());
    }
}
