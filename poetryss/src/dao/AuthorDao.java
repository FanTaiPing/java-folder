package dao;

import entity.Author;

import java.util.List;

/**
 * @author y
 */
public interface AuthorDao {
    /**
     * 查询作者表里的所有信息
     * @param start 开始的记录索引
     * @param rows  每页显示的记录条数
     * @return 返回一页的数据列表
     */
    List<Author> findAllAuthor(int start,int rows);

    /**
     * 查询作者表里面的记录条数
     * @return
     */
    int countAuthor();

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
