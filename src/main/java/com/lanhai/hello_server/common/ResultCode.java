package com.lanhai.hello_server.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    UNAUTHORIZED(401, "未授权"),
    FAIL(500, "服务器异常"); // 这里必须有 FAIL

    private final int code;
    private final String msg;
}