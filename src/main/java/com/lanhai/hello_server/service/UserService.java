package com.lanhai.hello_server.service;

import com.lanhai.hello_server.vo.UserDetailVO;

public interface UserService {
    UserDetailVO getUserDetail(Long userId);
    void updateUserInfo(Long userId, String phone, String email);
    void deleteUser(Long userId);
}