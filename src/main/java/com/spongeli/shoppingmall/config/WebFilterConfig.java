package com.spongeli.shoppingmall.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@ServletComponentScan
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class WebFilterConfig implements Filter {
    int i = 1;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-------------初始化----------");
        System.out.println(JSON.toJSONString(filterConfig));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getRequestURL());
        if (request.getRequestURL().toString().matches(".+.ico$")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String origin = request.getHeader("Origin");
            // 简单请求跨域，如果是跨域请求在响应头里面添加对应的Origin
            if (StringUtils.isNotEmpty(origin)) {
                response.addHeader("Access-Control-Allow-Origin", origin);
            }
            // 非简单请求跨域
            response.addHeader("Access-Control-Allow-Headers", "content-type");
            // 允许跨域请求的方法
            response.addHeader("Access-Control-Allow-Methods", "*");
            // 预检命令缓存 1小时
            //        response.addHeader("Access-Control-Max-Age", "3600");
            // 携带cookie的跨域
            response.addHeader("Access-Control-Allow-Credentials", "true");
            // 放行方法
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("------------销毁了----------");
    }
}
