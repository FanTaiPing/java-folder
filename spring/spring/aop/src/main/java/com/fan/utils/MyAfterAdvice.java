package com.fan.utils;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author y
 */
public class MyAfterAdvice implements AfterReturningAdvice {
    /**
     *
     * @param returnValue 返回值
     * @param method 当前执行方法
     * @param args 当前执行方法的参数
     * @param target 目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("返回值："+ returnValue);
        System.out.println("当前执行方法："+method.getName());
        System.out.println("当前执行方法的参数："+ args[0]);
        System.out.println("目标对象:"+target);
    }
}
