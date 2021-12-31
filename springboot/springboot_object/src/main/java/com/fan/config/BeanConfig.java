package com.fan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

/**
 * @author y
 */
@Configuration
public class BeanConfig {
    /**
     * @Bean 修饰方法或注解上，将方法返回值交给工厂管理
     * 方法名；推荐返回值首字母小写，代表当前创建对象在工厂中的名称
     * @return
     */
    @Bean
    public Calendar calender(){
        return Calendar.getInstance();
    }
}
