package com.lanhai.exception;

import com.lanhai.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截器，统一处理所有控制器抛出的异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获所有Exception类型异常，返回统一错误格式
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        // 打印异常栈，方便排查问题
        e.printStackTrace();
        return Result.error(e.getMessage());
    }
}