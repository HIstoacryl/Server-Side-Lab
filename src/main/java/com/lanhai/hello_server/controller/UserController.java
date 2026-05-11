package com.lanhai.hello_server.controller;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.security.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private JwtUtil jwtUtil;

    // 登录（正常）
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLoginDTO dto) {
        if ("test".equals(dto.getUsername()) && "123456".equals(dto.getPassword())) {
            String jwt = jwtUtil.generateToken(dto.getUsername());
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    // 注册
    @PostMapping("/register")
    public Result<String> register(@RequestBody UserLoginDTO dto) {
        return Result.success("注册成功");
    }

    // ===================== 【打开这个接口】用来测试 Token =====================
    @GetMapping("/detail/{userId}")
    public Result<String> detail(@PathVariable Long userId) {
        return Result.success("Token验证成功！用户ID：" + userId);
    }

}

// 登录参数
class UserLoginDTO {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}