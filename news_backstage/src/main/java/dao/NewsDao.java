package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
/**
 * 查询每页显示的新闻数据
 * @param start 开始的页码数
 * @param rows  每页显示的数据条数
 * @return
 */
	List<News> findNewsByPage(int start,int rows);
	/**
	 * 查询news表中总的数据条数
	 * @return
	 */
	int findNewsCount();
	/**
	 * 根据id查询新闻表里面的数据
	 * @param id
	 * @return
	 */
	News findNewsById(int id);
	/**
	 * 根据id修改新闻信息
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
