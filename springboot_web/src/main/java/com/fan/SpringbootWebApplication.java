package com.fan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口类
 */
@SpringBootApplication
@MapperScan("com.fan.dao")  //告诉他去哪里扫描dao进行接口映射  Mybatis映射扫描的包(相当于mybatis核心映射文件的mapper映射)
public class SpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }

}
