package service.impl;

import java.util.List;

import dao.NewsTypeDao;
import dao.impl.NewsTypeDaoImpl;
import entity.NewsType;
import service.NewsTypeService;

public class NewsTypeServiceImpl implements NewsTypeService{
private NewsTypeDao ntDao = new NewsTypeDaoImpl();
	@Override
	public List<NewsType> findAllNewsType() {
		// TODO Auto-generated method stub
		return ntDao.findAllNewsType();
	}

	@Override
	public List<NewsType> findNewsTypeById(int id) {
		// TODO Auto-generated method stub
		return ntDao.findNewsTypeById(id);
	}
}
