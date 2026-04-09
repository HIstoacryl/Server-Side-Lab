package com.lanhai.hello_server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.entity.SysUser;
import com.lanhai.hello_server.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @GetMapping("/page")
    public Result<Page<SysUser>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "5") int pageSize
    ) {
        return Result.success(sysUserService.getUserPage(pageNum, pageSize));
    }
}