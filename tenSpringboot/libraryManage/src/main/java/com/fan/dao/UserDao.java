package com.fan.dao;

import com.fan.entity.User;

public interface UserDao {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
}
