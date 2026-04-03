package com.lanhai.common;

/**
 * 统一API响应结果封装
 */
public class Result<T> {
    private int code;    // 响应码：200=成功，500=失败
    private String msg;  // 提示信息
    private T data;      // 响应数据

    // 成功（无数据）
    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功", null);
    }

    // 成功（带数据）
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    // 失败（自定义提示信息）
    public static <T> Result<T> error(String msg) {
        return new Result<>(500, msg, null);
    }

    // 构造方法、getter、setter
    public Result() {}
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}