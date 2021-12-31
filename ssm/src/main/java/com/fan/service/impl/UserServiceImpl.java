package com.fan.service.impl;

import com.fan.dao.UserDao;
import com.fan.entity.User;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author y
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

@Autowired
private UserDao userDao;

    /**
     * propagation = Propagation.SUPPORTS
     * 支持事务，外部存在事务融入当前事务，外部没有事务，不开启新的事务
     * @param username
     * @param password
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public User login(String username,String password) {
        return userDao.login(username,password);
    }
}
