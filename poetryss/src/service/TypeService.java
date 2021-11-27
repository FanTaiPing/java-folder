package service;

import entity.Author;
import entity.PageBean;
import entity.Type;

/**
 * @author y
 */
public interface TypeService{
    /**
     * 查询诗词类型表里面的所有信息
     * @param currentPage 当前页
     * @param rows  每页显示的记录条数
     * @return
     */
    PageBean<Type> findAllType(int currentPage, int rows);

    /**添加诗词类型信息是需用到
     * 根据诗词类型表里的type_name查询诗词表里面的id，再将查到的id插入到诗词表里
     * @param type_name
     * @return
     */
    Type findIdByName(String type_name);
}
