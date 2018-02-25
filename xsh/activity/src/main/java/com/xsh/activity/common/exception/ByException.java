package com.xsh.activity.common.exception;

/**
 * 自定义异常类
 *
 * @author by@Deng
 * @create 2017-08-02 15:01
 */
public class ByException extends RuntimeException {

    private Integer code;   //异常状态码

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    /**
     * 自定义异常信息
     * @author by@Deng
     * @date 2017/9/30 上午8:44
     */
    public ByException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    /**
     * 自定义异常信息,统一返回错误状态码为1
     * @author by@Deng
     * @date 2017/9/30 上午8:44
     */
    public ByException(String message) {
        super(message);
    }

}
