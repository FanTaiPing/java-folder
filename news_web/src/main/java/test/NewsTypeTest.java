package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.NewsTypeDao;
import dao.impl.NewsTypeDaoImpl;

public class NewsTypeTest {
private NewsTypeDao ntd =new NewsTypeDaoImpl();
	@Test
	public void testNewsType() {
		ntd.findAll().forEach(System.out::println);
		ntd.findTypeId(1).forEach(System.out::println);
	}
}
