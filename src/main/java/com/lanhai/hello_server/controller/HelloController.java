package com.lanhai.hello_server.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan(basePackages = "com.lanhai")
public class HelloController {

    // 加上这行注解！
    @GetMapping("/hello")
    public String hello(){
        return "Spring-Boot 接口运行成功！";
    }

}
