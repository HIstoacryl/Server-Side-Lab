package com.lanhai.hello_server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanhai.hello_server.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    Page<SysUser> getUserPage(int pageNum, int pageSize);
}