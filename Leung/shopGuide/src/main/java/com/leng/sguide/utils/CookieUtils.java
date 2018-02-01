package com.leng.sguide.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie工具类
 * cookie的key一般设置成英文
 * Created by by@Deng on 2017/7/11.
 */
public final class CookieUtils {

    /**
     * 设置cookie
     * 如果不需要设置时间，则为-1,若设置，单位为秒
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * @param isEncode
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "UTF-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage >= 0){
                cookie.setMaxAge(cookieMaxage);
            }
//            if(request !=null) {// 设置域名的cookie
//                String domainName = getDomainName(request);
//                System.out.println(domainName);
//                if (!"localhost".equals(domainName)) {
//                    //cookie.setDomain(domainName);
//                }
//            }
//            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Cookie的值
     * @param request
     * @param cookieName
     * @param isDecoder 是否编码
     * @return
     */
    public static String getCookie(HttpServletRequest request,String cookieName,boolean isDecoder){
        Cookie[] cookieList = request.getCookies();
        if(cookieList == null || cookieName ==null){
            return null;
        }
        String retValue = null;
        for(int i=0;i<cookieList.length;i++){
            if(cookieList[i].getName().equals(cookieName)){
                if(isDecoder){
                    try {
                        retValue = URLDecoder.decode(cookieList[i].getValue(),"UTF-8");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    retValue = cookieList[i].getValue();
                }
            }
        }
        return retValue;
    }


    /**
     * 删除cookie
     * @param request
     * @param response
     * @param cookieName
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
                                    String cookieName) {
        setCookie(request, response, cookieName, null, 0, false);
    }



    /**
     * 获取cookie的域名
     */
    private static final String getDomainName(HttpServletRequest request) {
        String domainName = null;

        String serverName = request.getRequestURL().toString();
        if (serverName == null || serverName.equals("")) {
            domainName = "";
        } else {
            final int end = serverName.lastIndexOf("/");
            serverName = serverName.substring(0, end);
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3) {
                // www.xxx.com.cn
                domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
                // xxx.com or xxx.cn
                domainName = "." + domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

}
