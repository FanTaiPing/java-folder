package com.fan.service;

import com.fan.entity.User;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
}
