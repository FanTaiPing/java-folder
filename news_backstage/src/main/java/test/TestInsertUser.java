package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class TestInsertUser {
private  UserService userService = new UserServiceImpl();
	@Test
	public void test() {
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123456");
		userService.userInsert(user);
	}

	@Test
	public void login() {
		User user = userService.login("admin", "admin");
		System.out.println(user);
		if(user != null) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	@Test
	public void userByIdTest() {
		User user = userService.userById(1);
		System.out.println(user);
	}
}
