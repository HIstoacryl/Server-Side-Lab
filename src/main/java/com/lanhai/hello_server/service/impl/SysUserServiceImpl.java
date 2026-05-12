package com.lanhai.hello_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanhai.hello_server.entity.SysUser;
import com.lanhai.hello_server.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Override
    public Page<SysUser> getUserPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public boolean saveBatch(Collection<SysUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<SysUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SysUser entity) {
        return false;
    }

    @Override
    public SysUser getOne(Wrapper<SysUser> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Optional<SysUser> getOneOpt(Wrapper<SysUser> queryWrapper, boolean throwEx) {
        return Optional.empty();
    }

    @Override
    public Map<String, Object> getMap(Wrapper<SysUser> queryWrapper) {
        return Map.of();
    }

    @Override
    public <V> V getObj(Wrapper<SysUser> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<SysUser> getBaseMapper() {
        return null;
    }

    @Override
    public Class<SysUser> getEntityClass() {
        return null;
    }
    // 先空着，不写任何方法实现
}