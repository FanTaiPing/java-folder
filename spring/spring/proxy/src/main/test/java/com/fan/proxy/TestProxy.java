package com.fan.proxy;

import com.fan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {
    @Test
    public void testProxy(){
        //开启工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("staticproxy.xml");
        UserService userService = (UserService) context.getBean("userServiceStaticProxy");
        userService.findAll("的范德萨发");

    }
}
