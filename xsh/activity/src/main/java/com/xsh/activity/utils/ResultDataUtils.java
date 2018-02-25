package com.xsh.activity.utils;

import com.xsh.activity.common.exception.CodeEnum ;
import com.xsh.activity.common.structure.entity.ResultEntity ;

/**
 * 返回数据的统一格式工具类
 *
 * @author by@Deng
 * @create 2017-12-01 09:56
 */
public class ResultDataUtils {

    /**
     * 返回成功带数据
     * @author by@Deng
     * @date 2017/12/1 上午9:57
     */
    public static ResultEntity success(Object data){
        ResultEntity resultData = new ResultEntity();
        resultData.setCode(CodeEnum.SUCCESS.getCode());    //成功状态码返回0
        resultData.setMessage(CodeEnum.SUCCESS.getMessage());  //提示信息
        resultData.setData(data);

        return resultData;
    }


    /**
     * 返回成功不带数据
     * @author by@Deng
     * @date 2017/12/1 上午9:57
     */
    public static ResultEntity success(){
        return success(null);
    }


    /**
     * 返回异常或错误
     * @author by@Deng
     * @date 2017/12/1 上午10:07
     */
    public static ResultEntity error(Integer code, String message){
        ResultEntity resultData = new ResultEntity();
        resultData.setCode(code);    //错误状态码
        resultData.setMessage(message);  //错误提示信息

        return resultData;
    }

}
