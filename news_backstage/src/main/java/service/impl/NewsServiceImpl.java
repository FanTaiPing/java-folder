package service.impl;

import java.util.List;

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import entity.News;
import entity.PageBean;
import service.NewsService;

public class NewsServiceImpl implements NewsService{
private NewsDao newsDao = new NewsDaoImpl();
private PageBean<News> pb = null;
	@Override
	public PageBean<News> findNewsByPage(int currentPage, int rows) {
		//创建空的page对象
		pb = new PageBean<News>();
		
		if (currentPage <= 1) {
			currentPage = 1;
		}
		//设置参数
		//
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		
		//调用dao查询数据库中news表中的总记录条数totalCount;
		int totalCount = newsDao.findNewsCount();
		pb.setTotalCount(totalCount);
		
		//计算总页码数
		int totalPage = (totalCount % rows == 0) ? (totalCount / rows) :(totalCount / rows)+1 ;
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		pb.setTotalPage(totalPage);
		
		//调用dao查list集合：每页显示的数据
		//先计算初始的页码索引 start = (当前页码-1) * rows(每页显示的数据条数)
		int start = (currentPage-1) * rows;
		List<News> list = newsDao.findNewsByPage(start, rows);
		//将list对象添加到pb对象里面
		pb.setList(list);

		//返回pb对象
		return pb;
	}
	@Override
	public News findNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.findNewsById(id);
	}
	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.updateNews(news);
	}
	@Override
	public int delNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.delNewsById(id);
	}
	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.addNews(news);
	}
}
