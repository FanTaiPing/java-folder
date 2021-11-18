package service;

import java.util.List;

import entity.News;
import entity.PageBean;

public interface NewsService{
	/**
	 * 查询每页显示的新闻数据
	 * @param currentPage 当前页码
	 * @param rows  每页显示的数据条数
	 * @return
	 */
		PageBean<News> findNewsByPage(int currentPage,int rows);
		/**
		 * 根据id查询新闻表里面的数据
		 * @param id
		 * @return
		 */
		News findNewsById(int id);
		/**
		 * 根据添加新闻信息
		 * @param news
		 * @return
		 */
		int updateNews(News news);
		/**
		 * 根据id删除新闻信息
		 * @return
		 */
		int delNewsById(int id);
		/**
		 * 添加新闻
		 * @param news
		 * @return
		 */
		int addNews(News news);
}
