package service;

import java.util.List;

import entity.NewsType;

public interface NewsTypeService {
	/**
	 * 查询新闻类型表里面的所有数据
	 * 
	 * @return
	 */
	List<NewsType> findAllNewsType();
	/**
	 * 根据id查询单条新闻得数据
	 * @param typeId
	 * @return
	 */
	List<NewsType> findNewsTypeById(int id);
}
