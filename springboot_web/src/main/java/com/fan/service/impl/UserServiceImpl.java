package com.fan.service.impl;

import com.fan.dao.UserDao;
import com.fan.entity.User;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
