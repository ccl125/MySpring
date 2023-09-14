package com.example.myspring.web;

import com.example.myspring.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CuiChengLong
 * @Date 2023/9/14 21:42
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 返回参数通过序列化可以将大写转换为小写
     *
     * @return User
     */
    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setDomain("WWW.BAIDU.COM");
        user.setUuId("LOVE");
        return user;
    }

    /**
     * Post请求-接收参数通过反序列化可以将小写转换为大写
     *
     * @param user
     * @return User
     */
    @PostMapping("/postUser")
    public User postUser(@RequestBody User user) {
        log.info("user:{}", user);
        return user;
    }

    @GetMapping("/get")
    public String hello(User user) {
        log.info("user:{}", user);
        return "Hello World";
    }

}
