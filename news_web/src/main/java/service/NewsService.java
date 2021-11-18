package service;

import java.util.List;

import entity.News;

public interface NewsService{
List<News> findAll(int currentSize,int pageSize,int totalPageCount);
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

