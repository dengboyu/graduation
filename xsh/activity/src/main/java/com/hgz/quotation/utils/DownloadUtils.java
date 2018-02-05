package com.hgz.quotation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 下载工具类
 *
 * @author by@Deng
 * @create 2017-12-15 12:07
 */
public class DownloadUtils {

    private static final Logger logger = LoggerFactory.getLogger(DownloadUtils.class);


    /**
     * 下载文件
     * @author by@Deng
     * @date 2017/12/15 下午2:11
     */
    public static HttpServletResponse download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径
            File file = new File(path);
            // 取得文件名
            String filename = file.getName();

            // 取得文件的后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 以流的形式下载文件
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream;charset=UTF-8");

            //支持中文
            String downloadName = URLEncoder.encode(filename,"UTF-8");
            response.addHeader("Content-Disposition", "attachment; filename="+downloadName);
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

}
