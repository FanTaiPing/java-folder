package dao;

import entity.Author;
import entity.Poetry;

import java.util.List;

/**
 * @author ljsy
 **/
public interface PoetryDao {


    /**
     * 返回指定起点和长度的诗词数组
     * @param start id开始点
     * @param size  返回集合长度
     * @return size个诗词
     */
    List<Poetry> findAll(int start,int from, int size);


    /**
     * 通过朝代找诗词 不含注释
     * @param id 朝代id
     * @param from
     * @param size
     * @return
     */
    List<Poetry> findByDynasty(int id, int from, int size);

    /**
     * 通过作者找诗词
     * @param id 作者id
     * @param start
     * @param size
     * @return
     */
    List<Poetry> findByAuthor(int id, int start, int size);

    /**
     * 通过类型找诗词
     * @param id 类型id
     * @param start
     * @param size
     * @return
     */
    List<Poetry> findByType(int id,int start, int size);


    /**
     * 所有诗词总数
     *
     * @return
     */
    int countAll();

    /**
     * 该朝代的诗词总数
     *
     * @param id
     * @return
     */
    int countByDynasty(int id);

    /**
     * 作者的作品数
     *
     * @param authorId
     * @return
     */
    int countByAuthor(int authorId);

    /**
     * 通过id找诗词
     *
     * @param poetryId
     * @return
     */
    Poetry findById(int poetryId);

    /**
     * 同类型诗词计数
     *
     * @param id
     * @return
     */
    int countByType(int id);

    /**
     * 标题中含有title的诗词
     *
     * @param title
     * @return
     */
    List<Poetry> findByTitle(String title, int from, int size);

    /**
     * 内容中含有content的诗词
     *
     * @param content
     * @return
     */
    List<Poetry> findByContent(String content, int from, int size);
}
