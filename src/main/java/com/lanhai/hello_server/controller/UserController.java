package com.lanhai.hello_server.controller;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.user.UserDTO;
import com.lanhai.hello_server.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 构造器注入，无警告
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Result<String> register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }
}