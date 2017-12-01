package com.yf.common.entity;

/**
 * 全局状态码
 */
public enum RestResponseCodeEnum {
    // 全局代码
    SUCCESS("20000", "请求成功"),
    FAILED("00010", "请求失败"),
    RECORD_EXIST("40000", "记录已存在"),
    RECORD_NOT_EXIST("40004", "记录不存在"),
    UNLAWFUL_REQUEST("40002", "非法请求"),
    PARAM_VERIFY_ERROR("40003", "参数验证失败"),

    // 用户
    VERIFY_USER_FAILED("00004", "用户名或密码有误"),
    NOT_PRIVILEGE("00005", "对不起，您的权限不足，请联系管理员"),

    // TOKEN
    TOKEN_NOT_EXIST("10000", "Token不能为空"),
    VERIFY_TOKEN_INVALID("10001", "无效Token"),

    // 文件代码
    FILE_TYPE("20001", "文件类型错误"),
    FILE_SIZE("20002", "文件大小错误");

    private String code;
    private String msg;

    RestResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
