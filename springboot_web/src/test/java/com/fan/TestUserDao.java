package com.fan;

import com.fan.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserDao {
    @Autowired
    private UserDao userDao;
    @Test
    public void testLogin(){
        System.out.println(userDao.login("刘备","123456"));

    }

}
