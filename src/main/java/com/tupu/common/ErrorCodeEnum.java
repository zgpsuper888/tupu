package com.tupu.common;

/**
 * 错误码
 *
 * @author Chunfu.Dong
 * @date 2019-08-03 11:07
 */
public enum  ErrorCodeEnum {
    TOKEN_ERROR(100000,"Token错误"),
    SYSTEM_ERROR(100001,"系统错误"),
    LOGIN_ERROR(100002,"登陆失败"),
    PARAM_ERROR(100003,"参数错误"),
    DATA_ERROR(100004,"数据重复"),
    INSERT_FAIL(4001,"插入失败"),
    DELETE_FAIL(4002,"删除失败"),
    UPDATA_FAIL(4003,"更新失败"),
    SELECT_FAIL(4001,"插入失败");

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