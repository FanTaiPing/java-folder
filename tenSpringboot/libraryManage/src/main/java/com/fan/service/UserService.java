package com.fan.service;

import com.fan.entity.User;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 判断用户表里是否存在此用户
     * @param name
     * @return
     */
    User isExistsUser(String name);
}
