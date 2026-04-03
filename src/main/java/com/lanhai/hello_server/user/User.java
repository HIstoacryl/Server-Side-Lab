package com.lanhai.hello_server.user;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
}