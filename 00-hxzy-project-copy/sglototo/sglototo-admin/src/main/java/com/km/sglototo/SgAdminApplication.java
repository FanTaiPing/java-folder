package com.km.sglototo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan({"com.km.sglototo.*.mapper"})
@EnableTransactionManagement
public class SgAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SgAdminApplication.class, args);



    }
}
