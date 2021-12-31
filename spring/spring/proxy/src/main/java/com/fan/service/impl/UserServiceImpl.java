package com.fan.service.impl;

import com.fan.service.UserService;

/**
 * 原始对象
 * @author y
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save(String name) {
            System.out.println("处理业务逻辑,调用DAO~~~");
    }

    @Override
    public void delete(String id) {
        System.out.println("处理业务逻辑,调用DAO~~~");
    }

    @Override
    public void update() {
        System.out.println("处理业务逻辑,调用DAO~~~");
    }

    @Override
    public String findAll(String name) {
        System.out.println("处理业务逻辑,调用DAO~~~");
        return name;
    }

    @Override
    public String findOne(String id) {
        System.out.println("处理业务逻辑,调用DAO~~~");
        return id;
    }
}
