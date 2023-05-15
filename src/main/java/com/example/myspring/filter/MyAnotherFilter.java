package com.example.myspring.filter;

import com.example.myspring.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author CuiChengLong
 * @Date 2023/5/13 20:07
 * @Description
 */
@Slf4j
//@Component
@Order(2)
public class MyAnotherFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyAnotherFilter 初始化");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest re = (HttpServletRequest) request;
        log.info("MyAnotherFilter 请求URL:{}", re.getRequestURL());
        chain.doFilter(re,response);
    }

    @Override
    public void destroy() {
        log.info("MyAnotherFilter destroy");
        Filter.super.destroy();
    }

}
