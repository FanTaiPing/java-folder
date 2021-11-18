package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import entity.News;

public class TestNews {
private NewsDao nd = new NewsDaoImpl();
	@Test
	public void testAddNews() {
		News news = new News();
		news.setTitle("1");
		news.setDesc("dsf");
		news.setAuthor("2");
		news.setContent("sdfhhg");
		news.setSmImg("dhfgk");
		news.setLaImg("sadfh");
		news.setTypeId(3);
		nd.addNews(news);
		System.out.print(news);
	}
	
	@Test
	public void testUpdateNews() {
		News news = new News();
		news.setTitle("1");
		news.setAuthor("2");
		news.setContent("sdfhhg");
		news.setSmImg("dhfgk");
		news.setLaImg("sadfh");
		news.setTypeId(3);
		news.setId(14);
		nd.updateNews(news);
		System.out.print(news);
	}

}
