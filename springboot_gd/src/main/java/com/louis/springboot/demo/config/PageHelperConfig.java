//package com.louis.springboot.demo.config;
//
//import com.github.pagehelper.PageHelper;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//@Configuration
//@MapperScan("com.louis.springboot.demo")
//public class PageHelperConfig {
//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","true");
//        properties.setProperty("rowBoundsWithCount","true");
//        properties.setProperty("pagesSizeZero","true");
//        properties.setProperty("reasonable","true");
//        return pageHelper;
//    }
//}
