package com.lanhai.hello_server.controller;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLoginDTO dto) {
        return userService.login(dto.getUsername(), dto.getPassword());
    }

    @GetMapping("/detail/{userId}")
    public Result<String> detail(@PathVariable Long userId) {
        return Result.success("Token验证成功！用户ID：" + userId);
    }
}

class UserLoginDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}