package com.lanhai.hello_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanhai.hello_server.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Update("update user_info set phone=#{phone}, email=#{email} where user_id=#{userId}")
    void updateByUserId(@Param("userId") Long userId,
                        @Param("phone") String phone,
                        @Param("email") String email);
}