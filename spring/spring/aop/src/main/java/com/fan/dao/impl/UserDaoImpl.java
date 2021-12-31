package com.fan.dao.impl;

import com.fan.dao.UserDao;

/**
 * @author y
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save(String name) {
        System.out.println("处理业务逻辑调用save dao---》" + name);
    }

    @Override
    public String findAll(String name) throws Exception {
        if("范德萨".equals(name)){
            throw new Exception("我发生异常了、、、");
        }
        System.out.println("处理业务逻辑调用findAll dao---》" + name);
        return name;
    }
}
