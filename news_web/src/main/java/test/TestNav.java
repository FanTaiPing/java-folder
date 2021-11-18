package test;

import org.junit.Test;

import service.NavService;
import service.impl.NavServiceImpl;

public class TestNav {
private NavService navDao = new NavServiceImpl();
	@Test
	public void testFindAll() {
		//jdk8的lambda表达式
		navDao.findAll().forEach(System.out::println);
	}

}
