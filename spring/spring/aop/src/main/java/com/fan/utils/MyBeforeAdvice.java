package com.fan.utils;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 自定义记录业务方法名称的前置通知
 * 前置通知：目标方法执行之前的额外操作
 * @author y
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    /**
     *
     * @param method 当前执行方法
     * @param args 当前执行方法的参数
     * @param target  目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("当前执行方法："+method.getName());
        System.out.println("当前执行方法的参数："+ args[0]);
        System.out.println("目标对象:"+target);
    }
}
