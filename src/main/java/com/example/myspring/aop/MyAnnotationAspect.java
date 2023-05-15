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
 * @Date 2023/5/13 12:54
 * @Description
 */
@Aspect
@Slf4j
@Component
@Order(2)
public class MyAnnotationAspect {

    @Pointcut("@annotation(com.example.myspring.annotation.MyAnnotation)")
    public void pointCut() {

    }


    @Around("pointCut()")
    public Object aroundAop(ProceedingJoinPoint pj) throws Throwable {
        String name = pj.getSignature().getName();
        log.info("环绕通知前...{}",name);
        Object result = pj.proceed();
        log.info("环绕通知后...{}",name);
        return result;
    }

}
