package com.itheima.exception;

public class BusinessException extends RuntimeException {
    public static int SYSTEM_ERROR_CODE = -1;
    public static String SSYSTEM_ERROR_MSG = "系统繁忙，稍后再试";
    private int code; // 错误码
    private String msg; // 错误信息

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
