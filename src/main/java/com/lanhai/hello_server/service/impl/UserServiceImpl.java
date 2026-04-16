package com.lanhai.hello_server.service.impl;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanhai.hello_server.mapper.SysUserMapper;
import com.lanhai.hello_server.mapper.UserDetailMapper;
import com.lanhai.hello_server.mapper.UserInfoMapper;
import com.lanhai.hello_server.service.UserService;
import com.lanhai.hello_server.vo.UserDetailVO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDetailMapper userDetailMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ObjectMapper objectMapper;

    // 👇 就是加这一行！
    private static final String CACHE_KEY = "user:detail:";

    @Override
    public UserDetailVO getUserDetail(Long userId) {
        String key = CACHE_KEY + userId;
        String json = stringRedisTemplate.opsForValue().get(key);

        if (StrUtil.isNotBlank(json)) {
            try {
                return objectMapper.readValue(json, UserDetailVO.class);
            } catch (Exception e) {
                stringRedisTemplate.delete(key);
            }
        }

        UserDetailVO vo = userDetailMapper.selectUserDetail(userId);
        if (vo != null) {
            try {
                stringRedisTemplate.opsForValue().set(key, objectMapper.writeValueAsString(vo), 10, TimeUnit.MINUTES);
            } catch (Exception ignored) {}
        }
        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(Long userId, String phone, String email) {
        userInfoMapper.updateByUserId(userId, phone, email);
        stringRedisTemplate.delete(CACHE_KEY + userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Long userId) {
        sysUserMapper.deleteById(userId);
        userInfoMapper.delete(null);
        stringRedisTemplate.delete(CACHE_KEY + userId);
    }
}