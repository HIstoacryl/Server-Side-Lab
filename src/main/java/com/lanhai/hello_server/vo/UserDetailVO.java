package com.lanhai.hello_server.vo;

import lombok.Data;

@Data
public class UserDetailVO {
    private Long userId;
    private String username;
    private String phone;
    private String email;
}