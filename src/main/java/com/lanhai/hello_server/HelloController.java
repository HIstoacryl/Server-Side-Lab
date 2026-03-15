package com.lanhai.hello_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 加上这行注解！
    @GetMapping("/hello")
    public String hello(){
        return "Spring-Boot 接口运行成功！";
    }

}
