package com.lanhai.hello_server.service.impl;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.security.JwtUtil;
import com.lanhai.hello_server.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final JwtUtil jwtUtil;

    public UserServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // 只留登录！其他全部删除！
    @Override
    public Result<String> login(String username, String password) {
        if ("test".equals(username) && "123456".equals(password)) {
            String jwt = jwtUtil.generateToken(username);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}