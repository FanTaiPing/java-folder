package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import entity.Page;

public class NewsTest {
private NewsDao newsDao = new NewsDaoImpl();
	@Test
	public void testNews() {
		newsDao.findAll(0,10).forEach(System.out::println);
	}
	@Test
public void testPageSize() {
	Page page = new Page();
	page.setTotalCount(newsDao.count());
	System.out.println("新闻总记录数是：" + newsDao.count());
	System.out.println("总的可以分多少页" + page.getTotalPageCount());
	}
}
