package com.yf.core.base;


/**
 * 数据传输基类
 */
public class RestResponse {

    private String code;
    private Object msg;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    /**
     * 请求成功
     *
     * @param data
     * @return
     */
    public void success(Object data) {
        builder(RestResponseCodeEnum.SUCCESS, data);
    }

    /**
     * 系统错误
     *
     * @return
     */
    public void failed() {
        builder(RestResponseCodeEnum.FAILED);
    }

    /**
     * 验证参数错误
     *
     * @return
     */
    public void verifyParamError(Object error) {
        builder(RestResponseCodeEnum.PARAM_VERIFY_ERROR, error, null);
    }

    public void builder(RestResponseCodeEnum restResponseCodeEnum, Object msg, Object data) {
        builder(restResponseCodeEnum.getCode(), msg, data);
    }

    public void builder(RestResponseCodeEnum restResponseCodeEnum, Object data) {
        builder(restResponseCodeEnum.getCode(), restResponseCodeEnum.getMsg(), data);
    }

    public void builder(RestResponseCodeEnum restResponseCodeEnum) {
        builder(restResponseCodeEnum, null);
    }

    public void success() {
        builder(RestResponseCodeEnum.SUCCESS, null);
    }

    private void builder(String code, Object msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse() {

    }


}
