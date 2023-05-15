package com.example.myspring.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author CuiChengLong
 * @Date 2023/5/13 20:06
 * @Description
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    //进入controller之前执行的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("已进入拦截器");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    //进入controller之后执行的
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("控制器controller执行完毕");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //整个拦截器执行之后执行（请求结果之后执行的）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("得到返回结果："+response);
        log.info("请求完毕");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
