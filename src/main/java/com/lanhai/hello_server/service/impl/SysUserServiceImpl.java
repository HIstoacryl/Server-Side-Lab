package com.lanhai.hello_server.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanhai.hello_server.entity.SysUser;
import com.lanhai.hello_server.mapper.SysUserMapper;
import com.lanhai.hello_server.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public Page<SysUser> getUserPage(int pageNum, int pageSize) {
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        baseMapper.selectPage(page, null);
        return page;
    }
}