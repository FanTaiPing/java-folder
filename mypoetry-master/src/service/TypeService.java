package service;

import entity.Page;
import entity.Type;

import java.util.List;

/**
 * @author ljsy
 **/
public interface TypeService {
    /**
     * 所有类型
     * @return 所有类型
     */
    List<Type> findAll( Page page );

    /**
     * 返回该作者的诗词的所有类型
     * @param id 作者ide
     * @return
     */
    List<Type> findByAuthor(int id, Page page );

    /**
     * 该作者的所有诗词的所有类型
     * @param id 作者id
     * @return
     */
    int typeForAuthorCount(int id);

    /**
     * 以id找类型
     * @param typeId
     * @return
     */
    Type findById(int typeId);

    /**
     * 所有类型的总数
     * @return
     */
    int countAll();
}
