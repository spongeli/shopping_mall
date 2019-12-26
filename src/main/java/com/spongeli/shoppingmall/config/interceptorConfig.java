package com.spongeli.shoppingmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 */
@Configuration
public class interceptorConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserHandlerInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(new MyInterceptor_copy()).addPathPatterns("/*");//有多个拦截器继续add进去
    }

    @Bean
    public UserHandlerInterceptor userHandlerInterceptor(){
        return new UserHandlerInterceptor();
    }
}
