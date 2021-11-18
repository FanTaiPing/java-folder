package service.impl;

import java.util.List;

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import entity.News;
import service.NewsService;

public class NewsServiceImpl implements NewsService {
private NewsDao newsDao = new NewsDaoImpl();
	@Override
	public List<News> findAll(int currentSize,int pageSize,int totalPageCount) {
		//计算分页前的公式
		//页码小于一时默认页码永远是1
		if(currentSize <= 0) {
			currentSize = 1;
		}
		//页码大于数据库所有记录所分的页码时，默认页码永远是最大的页码数
		if(currentSize >= totalPageCount) {
			currentSize = totalPageCount;
		}
		currentSize = (currentSize-1) * pageSize;
		return newsDao.findAll(currentSize,pageSize);
	}
	@Override
	public List<News> findDetail(int id) {
		// TODO Auto-generated method stub
		
		return newsDao.findDetail(id);
	}
	@Override
	public List<News> findHotNews() {
		// TODO Auto-generated method stub
		return newsDao.findHotNews();
	}
	@Override
	public int count() {

		return newsDao.count();
	}
}
