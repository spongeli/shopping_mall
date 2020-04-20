package com.spongeli.shoppingmall.config;

import com.spongeli.shoppingmall.common.bean.RequestMallUSerBean;
import com.spongeli.shoppingmall.common.cont.SystemConstant;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.ManagerRequestHolder;
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

@Configuration
public class ManagerUserHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;
    @Value("mall.token.key")
    private String tokenkey;
    private static final String START_TIME = "requestStartTime";
    private static final Logger logger = LogManager.getLogger(ManagerUserHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 保存用户请求时间
        request.setAttribute(START_TIME, System.currentTimeMillis());

        String uri = request.getRequestURI();
        if (uri.endsWith("/login")) return true;
        String token = request.getHeader("token");
        MallUser user = (MallUser) redisUtil.get(token);
        // 验证token是否正确
        if (user == null || !StringUtils.isEquals(token, MD5Util.getMD5(user.getUsername() + "-" + tokenkey))) {
            throw new SystemException(SystemConstant.LOGIN_EXPIRE, "登陆过期，请重新登陆");
        }
        // 存储上下文信息
        RequestMallUSerBean requestMallUSerBean = new RequestMallUSerBean();
        requestMallUSerBean.setToken(token);
        BeanUtils.copyProperties(user, requestMallUSerBean);
        ManagerRequestHolder.addAll(requestMallUSerBean, request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
//        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        ManagerRequestHolder.remove();
        // 计算本次请求时间差
        logger.info("request exception url:{},cost:{} ms", request.getRequestURI(),
                System.currentTimeMillis() - (long) request.getAttribute(START_TIME));
    }
}
