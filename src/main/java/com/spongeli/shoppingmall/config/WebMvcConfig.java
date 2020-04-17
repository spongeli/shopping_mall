package com.spongeli.shoppingmall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ManagerUserHandlerInterceptor managerUserHandlerInterceptor;
    @Autowired
    private WebUserHandlerInterceptor webUserHandlerInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        后台拦截
        registry.addInterceptor(managerUserHandlerInterceptor).addPathPatterns("/manager/**");
//        前台拦截
        registry.addInterceptor(webUserHandlerInterceptor).addPathPatterns("/web/**");
        super.addInterceptors(registry);
    }
}