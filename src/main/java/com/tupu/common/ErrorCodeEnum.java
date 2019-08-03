package com.tupu.common;

/**
 * 错误码
 *
 * @author Chunfu.Dong
 * @date 2019-08-03 11:07
 */
public enum  ErrorCodeEnum {
    SYSTEM_ERROR(100001,"系统错误"),
    SYSTEM_BUSY(100002,"系统繁忙");

    private int code;

    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}