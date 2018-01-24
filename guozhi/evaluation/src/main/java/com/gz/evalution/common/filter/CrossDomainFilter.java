package com.gz.evalution.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域请求
 *
 * @author by@Deng
 * @create 2017-12-22 16:59
 */
@WebFilter(filterName = "CrossDomainFilter",urlPatterns = "/*")
public class CrossDomainFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        res.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Credentials", "true"); //是否允许请求带有验证信息
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, REST");//允许自定义的头部，以逗号隔开，大小写不敏感
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");//允许使用的请求方法
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3009"); //允许跨域访问的域,只对域名有效，对目录无效
        //缓存此次请求的秒数,在这个时间范围内，所有同类型的请求都将不再发送预检请求而是直接使用此次返回的头作为判断依据，大幅优化请求次数
        response.setHeader("Access-Control-Max-Age", "3600");

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
