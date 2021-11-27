package service;

import entity.Author;
import entity.PageBean;

/**
 * @author y
 */
public interface AuthorService{
    /**
     * 查询作者表里面的所有信息
     * @param currentPage 当前页
     * @param rows  每页显示的记录条数
     * @return
     */
    PageBean<Author> findAllAuthor(int currentPage, int rows);

    /**添加诗词信息是需用到
     * 根据作者表里的name查询诗词表里面的id，再将查到的id插入到诗词表里
     * @param name
     * @return
     */
    Author findIdByName(String name);
    /**
     * 根据id删除作者信息
     * @param id
     * @return
     */
    int deleteAuthorById(int id);
}
