package com.fan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fan.dao")
public class BankOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankOnlineApplication.class, args);
    }

    /**
     * pageHelper分页配置
     * @return
     */
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
}
