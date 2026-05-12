package com.lanhai.hello_server.service;

import com.lanhai.hello_server.common.Result;

public interface UserService {
    Result<String> login(String username, String password);
}