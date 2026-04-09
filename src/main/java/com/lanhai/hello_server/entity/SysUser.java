package com.lanhai.hello_server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class SysUser {
    private Long userId;
    private String username;
    private String password;
}