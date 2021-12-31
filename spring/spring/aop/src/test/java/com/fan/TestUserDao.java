package com.fan;

import com.fan.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    @Test
    public void testBeforeAdvice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beforeTarget.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save("范德萨");
    }
@Test
    public void testAfterAdvice() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("afterAdvice.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.findAll("范德萨");
    }
    @Test
    public void testInterception() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("interceptionAdvice.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.findAll("范德萨");
    }

    @Test
    public void testException() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("exceptionAdvice.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.findAll("范德萨");
    }
}
