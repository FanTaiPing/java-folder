package com.fan.dao;

import com.fan.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 登录查询功能
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username")String username,@Param("password") String password);
}
