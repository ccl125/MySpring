package com.example.myspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author CuiChengLong
 * @Date 2023/5/13 12:22
 * @Description
 */
@Aspect
@Slf4j
//@Component
@Order(1)
public class MyAspect {

    @Pointcut("execution(* com.example.myspring.web..*(..))")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object Around(ProceedingJoinPoint point) throws Throwable {
        log.info("环绕通知方法执行前Before");
        Object result = point.proceed();
        log.info("环绕通知方法执行后After");
        return result;
    }

}

