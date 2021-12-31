package com.fan.service.impl;

import com.fan.dao.UserDao;
import com.fan.entity.Users;
import com.fan.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<Users> findAll() {
        return userDao.findAll();
    }

    @Override
    public int insertUser(Users user) {
        return userDao.insertUser(user);
    }

    @Override
    public Users getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(Users user) {
        userDao.updateUser(user);
    }

    @Override
    public void delUser(int id) {
        userDao.delUser(id);
    }

    @Override
    public List<Users> findLikeUsernameOrTelephone(String username, String telephone) {
        return userDao.findLikeUsernameOrTelephone(username,telephone);
    }
}
