package com.xsh.activity.utils;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具类
 *
 * @author by@Deng
 * @create 2017-10-14 10:10
 */
public class GenericsUtils {

    /**
     * 获取字节码文件
     * @author by@Deng
     * @date 2017/10/14 上午10:11
     */
    public static Class getSuperClassGenricType(Class clazz) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (!(params[0] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[0];
    }




}
