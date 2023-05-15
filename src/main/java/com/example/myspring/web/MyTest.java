package com.example.myspring.web;

import com.example.myspring.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CuiChengLong
 * @Date 2023/5/13 11:09
 * @Description
 */
@RestController
@RequestMapping("/ccl")
@Slf4j
public class MyTest {

    @GetMapping("/hello")
//    @MyAnnotation
    public String hello() {
        log.info("==========方法执行=========");
        return "Hello World";
    }



}
