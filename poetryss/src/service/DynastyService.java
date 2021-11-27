package service;

import entity.Author;
import entity.Dynasty;
import entity.PageBean;

/**
 * @author y
 */
public interface DynastyService {
    /**
     * 查询朝代表里面的所有信息
     * @param currentPage 当前页
     * @param rows  每页显示的记录条数
     * @return
     */
    PageBean<Dynasty> findAllDynasty(int currentPage, int rows);

    /**
     *
     * @param id
     * @return
     */
    int deleteDynastyById(int id);
}
