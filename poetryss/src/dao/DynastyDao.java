package dao;

import entity.Author;
import entity.Dynasty;

import java.util.List;

/**
 * @author y
 */
public interface DynastyDao {
    /**
     * 查询朝代表里的所有信息
     * @param start 开始的记录索引
     * @param rows  每页显示的记录条数
     * @return 返回一页的数据列表
     */
    List<Dynasty> findAllDynasty(int start, int rows);

    /**
     * 查询朝代表里面的记录条数
     * @return
     */
    int countDynasty();
    /**
     *
     * @param id
     * @return
     */
    int deleteDynastyById(int id);
}
