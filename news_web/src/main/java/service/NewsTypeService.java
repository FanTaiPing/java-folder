package service;

import java.util.List;

import entity.NewsType;

public interface NewsTypeService{
List<NewsType> findAll();
/**
 * 根据news表中的type_id和news_type表中的id关联id查询
 * @param id
 * @return
 */
List<NewsType> findTypeId(int id);
}
