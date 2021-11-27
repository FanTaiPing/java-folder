package dao;

import entity.Type;

import java.util.List;

/**
 * @author ljsy
 **/
public interface TypeDao {
    /**
     * 所有类型
     * @param start 开始位置
     * @param size  获取数据的数量
     * @return 所有类型
     */
    List<Type> findAll(int start,int size);

    /**
     * 返回该作者的诗词的所有类型
     * @param id 作者id
     * @param start
     * @param size
     * @return
     */
    List<Type> findByAuthor(int id, int start, int size);

    /**
     * 该作者的所有诗词的所有类型
     * @param id 作者id
     * @return
     */
    int typeForAuthorCount(int id);

    /**
     * 以id找类型
     *
     * @param typeId
     * @return
     */
    Type findById(int typeId);


    /**
     * 所有类型的总数
     *
     * @return
     */
    int countAll();
}
