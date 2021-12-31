package com.fan.service;

import com.fan.entity.User;

public interface UserService {
    /**
     * 登录查询功能
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
}
