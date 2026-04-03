package com.lanhai.hello_server.user;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.common.ResultCode;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    // 内存存储，不连数据库
    private static final Map<String, String> USER_MAP = new HashMap<>();

    @Override
    public Result<String> register(UserDTO userDTO) {
        if (USER_MAP.containsKey(userDTO.getUsername())) {
            return Result.error(ResultCode.USER_HAS_EXISTED);
        }
        USER_MAP.put(userDTO.getUsername(), userDTO.getPassword());
        return Result.success("注册成功");
    }

    @Override
    public Result<String> login(UserDTO userDTO) {
        String pwd = USER_MAP.get(userDTO.getUsername());
        if (pwd == null) {
            return Result.error(ResultCode.USER_NOT_EXIST);
        }
        if (!pwd.equals(userDTO.getPassword())) {
            return Result.error(ResultCode.PASSWORD_ERROR);
        }
        return Result.success("登录成功 token: 123456");
    }
}