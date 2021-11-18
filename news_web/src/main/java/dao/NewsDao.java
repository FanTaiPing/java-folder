package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	/**
	 * 查新闻表里的所有的新闻信息 分页查询
	 * @return
	 * currentSize 当前页
	 * pageSize    一页显示几条数据
	 */

List<News> findAll(int currentSize,int pageSize);
/**
 * 根据id查询单条新闻的信息
 * @param id
 * @return
 */
List<News> findDetail(int id);
/**
 * 查询新闻表的热点新闻信息部分
 * @return
 */
List<News> findHotNews();
/**
 * 获取数据库中新闻的总记录数
 * @return
 */
int count();
}
