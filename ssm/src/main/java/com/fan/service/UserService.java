package com.fan.service;

import com.fan.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
}
