package com.spongeli.shoppingmall.config;

import com.spongeli.shoppingmall.common.bean.RequestMallUSerBean;
import com.spongeli.shoppingmall.common.bean.ShoppingUserEx;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.RequestHolder;
import com.spongeli.shoppingmall.common.system.ShoppingUserHolder;
import com.spongeli.shoppingmall.common.system.SystemConstant;
import com.spongeli.shoppingmall.common.util.RedisUtil;
import com.spongeli.shoppingmall.pojo.model.MallUser;
import com.spongeli.shoppingmall.utils.MD5Util;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/3/6 11:18
 **/
@Configuration
public class ShoppingUserHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;
    @Value("mall.user.login.key")
    private String loginKey;

    private static final String START_TIME = "requestStartTime";
    private static final Logger logger = LogManager.getLogger(ShoppingUserHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 保存用户请求时间
        request.setAttribute(START_TIME, System.currentTimeMillis());

        String uri = request.getRequestURI();
        logger.info("前台请求拦截");

        String token = request.getHeader("token");
        ShoppingUserEx ex =  (ShoppingUserEx)redisUtil.get(token);

        logger.info(ex);
        // 存储上下文信息
        ShoppingUserHolder.addAll(ex, request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
//        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        RequestHolder.remove();
        // 计算本次请求时间差
        logger.info("request exception url:{},cost:{} ms", request.getRequestURI(),
                System.currentTimeMillis() - (long) request.getAttribute(START_TIME));
    }
}
