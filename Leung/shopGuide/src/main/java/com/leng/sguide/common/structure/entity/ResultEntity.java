package com.leng.sguide.common.structure.entity;

/**
 * 统一返回数据格式
 *
 * @author by@Deng
 * @create 2017-12-01 09:52
 */
public class ResultEntity<T> {

    private Integer code;   //返回状态码
    private String message; //返回提示信息
    private T  data;   //返回的数据

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
