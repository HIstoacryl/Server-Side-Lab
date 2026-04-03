package com.lanhai.hello_server.common;

import lombok.Getter;

@Getter
public enum ResultCode {

    // 成功
    SUCCESS(200, "操作成功"),

    // 参数错误
    PARAM_ERROR(400, "参数不能为空"),

    // 用户错误
    USER_EXIST(409, "用户名已存在"),
    USER_NOT_EXIST(404, "用户不存在"),
    PASSWORD_ERROR(401, "密码错误"),

    UNAUTHORIZED(401, "未授权，请先登录"),

    // 系统错误
    ERROR(500, "服务器异常");

    private final Integer code;
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}