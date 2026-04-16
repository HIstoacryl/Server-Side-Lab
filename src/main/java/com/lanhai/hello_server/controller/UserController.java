package com.lanhai.hello_server.controller;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.common.ResultCode;
import com.lanhai.hello_server.service.UserService;
import com.lanhai.hello_server.vo.UserDetailVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

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