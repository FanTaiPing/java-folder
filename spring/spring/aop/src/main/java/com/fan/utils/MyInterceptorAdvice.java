package com.fan.utils;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author y
 */
public class MyInterceptorAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("记录方法运行时间通知：");
        long startTime = System.currentTimeMillis();
        //执行方法调用（返回值为目标方法返回值，这个返回值一定要在通知类中返回）
        Object proced = invocation.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + (endTime - startTime));
        return proced;
    }
}
