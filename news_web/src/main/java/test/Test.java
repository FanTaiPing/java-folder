package test;

import static org.junit.Assert.*;

import java.util.Scanner;

import dao.impl.UserDaoImpl;
import entity.User;

public class Test {
UserDaoImpl udi = new UserDaoImpl();
Scanner input = new Scanner(System.in);
	@org.junit.Test
	public void test() {
		
		User user = udi.login("admin", "admin");
		System.out.println(user);
	}

	@org.junit.Test
	public void TestExistsUser() {
		System.out.println("输入用户名：");
		String username = input.next();
		User user = udi.isExistsUser(username);
		if(user != null) {
			System.out.println("此用户已存在，无法注册！！");
			TestExistsUser();
		}else {
			System.out.println("此用户不存在，您可以进行注册！！");
			
		}
	}
	
	@org.junit.Test
	public void testInsertUser() {
		User user = new User();
		user.setUsername("小明");
		user.setPassword("123456");
		int flag = udi.insertUser(user);
		//success
		if(flag == 1) {
			System.out.println("注册用户成功！！");
		//fail	
		}else {
			System.out.println("注册用户失败！！！");
		}
	}
}
