package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@ComponentScan(value="rds")
@ComponentScan(value="com")
@RestController
@RequestMapping("/")
@SpringBootApplication
public class FileApplication {


    @RequestMapping("/")
    public String index(){
        return "fileservice sucessfull !";
    }

//    public static void main(String[] args) {
//        SpringApplication.run(FileApplication.class, args);
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(FileApplication.class).run(args);
    }

}
