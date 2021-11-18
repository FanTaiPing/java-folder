package service.impl;

import java.util.List;

import dao.NewsTypeDao;
import dao.impl.NewsTypeDaoImpl;
import entity.NewsType;
import service.NewsTypeService;

public class NewsTypeServiceImpl implements NewsTypeService{
private NewsTypeDao newsDao = new NewsTypeDaoImpl();
	@Override
	public List<NewsType> findAll() {
		// TODO Auto-generated method stub
		return newsDao.findAll();
	}
	@Override
	public List<NewsType> findTypeId(int id) {
		// TODO Auto-generated method stub
		return newsDao.findTypeId(id);
	}
}
