package com.hgz.quotation.utils;

import com.hgz.quotation.common.sysconstant.Constants ;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by zeal on 2015-09-03.
 */
public class Base64Utils {

    /**
     * 将文件转成base64 字符串
     * @param path
     * @return  *
     * @throws Exception
     */

    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);

    }

    /**
     * 将base64字符解码保存文件
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */

    public static void decodeBase64File(String base64Code, String targetPath)
            throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();

    }

    /**
     * 将base64字符转换成二进制数据
     * @param base64Code
     * @throws Exception
     */

    public static byte[] toByteArray(String base64Code)
            throws Exception {
        if(base64Code==null)
            return null;
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        return buffer;
    }

    /**
     * 将base64字符保存到文本文件
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */

    public static void toTxtFile(String base64Code, String targetPath)
            throws Exception {

        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }


    /**
     * 将字符串编码为base64编码
     * @author by@Deng
     * @date 2017/10/15 下午11:15
     */
    public static String convert(String str) {
        byte[] value;
        try {
            value = str.getBytes(Constants.DEFAULTCHARSET);
            return new String(Base64.encodeBase64(value),Constants.DEFAULTCHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
