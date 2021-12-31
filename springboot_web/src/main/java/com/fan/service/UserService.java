package com.fan.service;

import com.fan.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     */
    User login(@Param("username")String username, @Param("password")String password);
}
