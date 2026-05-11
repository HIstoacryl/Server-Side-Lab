package com.lanhai.exception;

import com.lanhai.hello_server.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        // 直接返回错误信息，不乱用枚举！
        return Result.error(e.getMessage());
    }
}