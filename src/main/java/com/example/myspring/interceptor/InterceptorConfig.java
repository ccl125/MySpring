package com.example.myspring.interceptor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author CuiChengLong
 * @Date 2023/5/13 22:16
 * @Description
 */
//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private MyInterceptor myInterceptor;

    @Resource
    private AnotherInterceptor anotherInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(anotherInterceptor);
        registry.addInterceptor(myInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
