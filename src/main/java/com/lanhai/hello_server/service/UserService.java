package com.lanhai.hello_server.service;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.vo.UserDetailVO;

public interface UserService {

    // 原有方法
    UserDetailVO getUserDetail(Long userId);
    void updateUserInfo(Long userId, String phone, String email);
    void deleteUser(Long userId);

    // 必须加这一行！！！
    Result<String> login(String username, String password);
}