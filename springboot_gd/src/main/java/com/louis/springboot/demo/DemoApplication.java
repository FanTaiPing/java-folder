package com.louis.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@MapperScan("com.louis.springboot.demo")
public class DemoApplication {

	@RequestMapping("/")
	public String index(){
		return "9090 sucessfull !";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}