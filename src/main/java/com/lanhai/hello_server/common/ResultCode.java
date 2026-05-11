package com.lanhai.hello_server.common;

public enum ResultCode {
    SUCCESS(200, "成功"),
    ERROR(500, "服务器异常");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() { return code; }
    public String getMsg() { return msg; }
}