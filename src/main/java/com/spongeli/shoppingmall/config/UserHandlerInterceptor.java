package com.spongeli.shoppingmall.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class UserHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LogManager.getLogger(UserHandlerInterceptor.class);
    public UserHandlerInterceptor() {
    }
//    @Autowired
//    private MallUserMapper dao;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        RequestWrapper myRequestWrapper = new RequestWrapper((HttpServletRequest) request);
        String body = myRequestWrapper.getBody();
        System.out.println("我是拦截器："+body);
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
