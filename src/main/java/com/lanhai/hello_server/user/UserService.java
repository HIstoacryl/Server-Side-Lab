package com.lanhai.hello_server.user;

import com.lanhai.hello_server.common.Result;

public interface UserService {
    Result register(UserDTO userDTO);
    Result login(UserDTO userDTO);
    Result getUserById(Long id);
}