package com.gz.evalution.utils;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * IO工具类
 * @author by@Deng
 * @create 2017-12-06 13:55
 */
public class IOUtils {

    /**
     * 将对象转为字节数组
     * @author by@Deng
     * @date 2017/12/6 下午1:55
     */
    public static byte[] objectToByteArray(Object obj) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }


    /**
     * 将字节数组转为对象
     * @author by@Deng
     * @date 2017/12/6 下午1:57
     */
    public static Object byteArrayToObject(byte[] bytes) {
        Object obj = null;
        try {
            // byteArray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);

            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }

}
