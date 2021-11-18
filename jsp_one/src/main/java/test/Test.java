package test;

import static org.junit.Assert.*;

import java.util.Scanner;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class Test {
UserService us = new UserServiceImpl();
Scanner input = new Scanner(System.in);
	@org.junit.Test
	public void test() {
		
		User user = us.login("admin", "admin");
		System.out.println(user);
	}

	@org.junit.Test
	public void TestExistsUser() {
		System.out.println("输入用户名：");
		String username = input.next();
		User user = us.isExistsUser(username);
		if(user != null) {
			System.out.println("此用户已存在，无法注册！！"+user);
			TestExistsUser();
		}else {
			System.out.println("此用户不存在，您可以进行注册！！"+user );
			
		}
	}
}
