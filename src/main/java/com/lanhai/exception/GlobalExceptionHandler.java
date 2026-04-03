package com.lanhai.exception;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.common.ResultCode;
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
    public Result handleException(Exception e) {
        // 打印异常栈，方便排查问题
        e.printStackTrace();
        return Result.error(ResultCode.valueOf(e.getMessage()));
    }
}