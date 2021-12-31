package com.fan.dao.impl;

import com.fan.dao.UserDao;

/**
 * @author y
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save(String name) {
        System.out.println("添加的名字为:" + name);
    }
}
