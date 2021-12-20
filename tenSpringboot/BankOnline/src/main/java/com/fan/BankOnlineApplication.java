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

}
