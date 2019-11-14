package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 于振华
 * @create 2019-11-06 21:01
 */
@Configuration
public class configInterceptor implements WebMvcConfigurer {
    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //InterceptorRegistration inter = registry.addInterceptor(new LoginHendlerInterceptor());
        //inter.addPathPatterns("/**");//拦截请求
        //inter.excludePathPatterns("/login","/","/log","/register","/doRegister","/**/*.css","/**/*.js./**/*.img");//排除



    }
}
