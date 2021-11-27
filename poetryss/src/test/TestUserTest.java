package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author y
 */
public class TestUserTest {
    private UserService userService = new UserServiceImpl();
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void testUser() {
        User user = userService.login("admin", "admin");
        System.out.println(user);
    }
    @Test
    public void testCount(){
        System.out.println(userDao.countUser());
    }
    @Test
    public void testFindUser(){
        List<User> list = userDao.findAllUser(0,10);
        System.out.println(list);
    }
}