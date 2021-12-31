package com.fan.utils;

import com.fan.dao.UserDao;
import org.springframework.aop.ThrowsAdvice;

/**
 * @author y
 */
public class MyException implements ThrowsAdvice {
    public void afterThrowing(Exception e) {
        System.out.println("ex:" + e.getMessage());
    }
}
