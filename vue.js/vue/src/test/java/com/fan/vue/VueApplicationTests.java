package com.fan.vue;

import com.fan.dao.UserDao;
import com.fan.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VueApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void findAllTest() {
        List<Users> userList = userDao.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void updateUser() {
        Users user = new Users();
        user.setId(1);
        user.setUsername("刘备");
        user.setAge(100);
        user.setSalary(10000);
        user.setTelephone("15511551311");
        userDao.updateUser(user);
    }

    @Test
    public void testFindLike() {
        List<Users> list = userDao.findLikeUsernameOrTelephone("张", null);
        list.forEach(System.out::println);
    }
}
