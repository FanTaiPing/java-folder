package dao;

import entity.Author;
import entity.Type;

import java.util.List;

/**
 * @author y
 */
public interface TypeDao {
    /**
     * 查询诗词类型表里的所有信息
     * @param start 开始的记录索引
     * @param rows  每页显示的记录条数
     * @return 返回一页的数据列表
     */
    List<Type> findAllType(int start, int rows);

    /**
     * 查询诗词类型表里面的记录条数
     * @return
     */
    int countType();

    /**添加诗词类型信息是需用到
     * 根据诗词类型表里的type_name查询诗词表里面的id，再将查到的id插入到诗词表里
     * @param type_name
     * @return
     */
    Type findIdByName(String type_name);
}
