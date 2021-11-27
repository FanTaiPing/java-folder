package dao;

import entity.Author;
import entity.Poetry;

import java.util.List;

/**
 * @author y
 */
public interface PoetryDao {
    /**
     * 查询古诗词表里的所有信息
     * @param start 开始的记录索引
     * @param rows  每页显示的记录条数
     * @return 返回一页的数据列表
     */
    List<Poetry> findAllPoetry(int start, int rows);

    /**
     * 查询古诗词表里面的记录条数
     * @return
     */
    int countPoetry();

    /**
     * 根据id查询古诗信息
     * @param id
     * @return
     */
    Poetry findPoetryById(int id);

    /**
     * 根据id删除古诗信息
     * @param id
     * @return
     */
    int deletePoetryById(int id);

    /**
     * 添加诗词信息
     * @param poetry
     * @return
     */
    int addPoetry(Poetry poetry);

    /**
     * 根据id修改诗词信息
     * @param poetry
     * @return
     */
    int updatePoetry(Poetry poetry);

}
