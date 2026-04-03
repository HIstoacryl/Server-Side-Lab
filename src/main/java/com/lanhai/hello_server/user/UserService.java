package com.lanhai.hello_server.user;

import com.lanhai.hello_server.common.Result;

public interface UserService {
    Result<String> register(UserDTO userDTO);
    Result<String> login(UserDTO userDTO);
}