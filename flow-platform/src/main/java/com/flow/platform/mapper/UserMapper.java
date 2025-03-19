package com.flow.platform.mapper;

import com.flow.platform.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    List<User> findAll();

    @Select("SELECT * FROM sys_user WHERE user_id = #{userId}")
    User findById(Long userId);

    @Select("SELECT * FROM sys_user WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO sys_user (username, password, email, wx_userid, status) " +
            "VALUES (#{username}, #{password}, #{email}, #{wxUserid}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insert(User user);

    @Update("UPDATE sys_user SET username = #{username}, email = #{email}, status = #{status} " +
            "WHERE user_id = #{userId}")
    void update(User user);

    @Delete("DELETE FROM sys_user WHERE user_id = #{userId}")
    void deleteById(Long userId);
}