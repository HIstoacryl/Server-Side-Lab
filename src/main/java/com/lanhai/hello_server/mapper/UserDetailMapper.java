package com.lanhai.hello_server.mapper;

import com.lanhai.hello_server.vo.UserDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDetailMapper {
    @Select("SELECT su.user_id, su.username, ui.phone, ui.email " +
            "FROM sys_user su LEFT JOIN user_info ui ON su.user_id = ui.user_id " +
            "WHERE su.user_id = #{userId}")
    UserDetailVO selectUserDetail(@Param("userId") Long userId);
}