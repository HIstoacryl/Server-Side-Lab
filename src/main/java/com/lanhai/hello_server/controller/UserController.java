package com.lanhai.hello_server.controller;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.service.UserService;
import com.lanhai.hello_server.vo.UserDetailVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // ===================== 我给你加的登录、注册接口 =====================
    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLoginDTO dto) {
        // 简单返回成功，仅用于测试拦截是否生效
        return Result.success("登录成功");
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody UserLoginDTO dto) {
        return Result.success("注册成功");
    }
    // =================================================================

    @GetMapping("/detail/{userId}")
    public Result<UserDetailVO> detail(@PathVariable Long userId) {
        return Result.success(userService.getUserDetail(userId));
    }

    @GetMapping("/info/{userId}")
    public Result<?> update(@PathVariable Long userId,
                            @RequestParam String phone,
                            @RequestParam String email) {
        userService.updateUserInfo(userId, phone, email);
        return Result.success();
    }

    @DeleteMapping("/{userId}")
    public Result<?> delete(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return Result.success();
    }
}

// 登录参数类（不需要新建文件）
class UserLoginDTO {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}