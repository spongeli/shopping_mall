package com.spongeli.shoppingmall.config;

import com.spongeli.shoppingmall.common.util.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class UserHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;
    private static final Logger logger = LogManager.getLogger(UserHandlerInterceptor.class);
    public UserHandlerInterceptor() {}
//    @Autowired
//    private MallUserMapper dao;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        logger.info("拦截器被使用");
        String token =  request.getHeader("token");
        Object ss = redisUtil.get("token");
        System.out.println(ss);

        logger.info("token={}",token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        System.out.println("afterCompletion");
    }
}
