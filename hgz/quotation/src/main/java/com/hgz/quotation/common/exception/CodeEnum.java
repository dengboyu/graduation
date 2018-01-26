package com.hgz.quotation.common.exception;

/**
 * 返回数据的状态码和提示信息
 *
 * @author by@Deng
 * @create 2017-12-01 09:58
 */
public enum CodeEnum {

    UNKNOW_ERROR(-1,"系统错误"),
    SUCCESS(0,"成功"),
    CUSTOMIZED(1,"自定义异常"),
    ;

    private Integer code;   //返回状态码
    private String message; //返回提示信息


    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
