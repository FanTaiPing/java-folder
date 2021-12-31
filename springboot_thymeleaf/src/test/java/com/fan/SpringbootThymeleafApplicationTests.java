package com.fan;

import com.fan.dao.EmpDao;
import com.fan.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootThymeleafApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EmpDao empDao;
    @Test
    public void loginTest() {
        System.out.println(userDao.login("刘备","123456"));
    }
    @Test
    public void empFindAll(){
        System.out.println(empDao.empFindAll());
    }

}
