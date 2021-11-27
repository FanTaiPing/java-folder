package service;

import entity.Page;
import entity.Poetry;

import java.util.List;

/**
 * @author ljsy
 **/
public interface PoetryService {
    /**
     * 搜索词搜索的结果
     * @param word 搜索词
     * @return
     */
    List<Poetry> searchPoetry(String word, Page page );

    /**
     * 返回指定id开始的诗词数组
     * @param start 返回的诗词的id将大于start
     * @return 诗词
     */
    List<Poetry> findAll(int start, Page page);

    /**
     * 通过朝代找诗词 不含注释
     * @param id 朝代id
     * @return
     */
    List<Poetry> findByDynasty(int id, Page page );

    /**
     * 通过作者找诗词
     * @param id 作者id
     * @return
     */
    List<Poetry> findByAuthor(int id,  Page page );

    /**
     * 通过类型找诗词
     * @param id 类型id
     * @return 含注释等的诗词对象的集合
     */
    List<Poetry> findByType(int id, Page page );

    /**
     * 通过作者和类型找诗词
     * @param authorId
     * @param typeId
     * @return
     */
    List<Poetry> findByAuthorAndType(int authorId, int typeId,Page page );

    /**
     * 作者的作品数
     * @param authorId
     * @return
     */
    int countByAuthor(int authorId);

    /**
     * 通过id找诗词
     * @param poetryId
     * @return
     */
    Poetry findById(int poetryId);

    /**
     * 同类型诗词计数
     * @param id
     * @return
     */
    int countByType(int id);

    /**
     * 所有诗词总数
     * @return
     */
    int countAll();

    /**
     * 该朝代的诗词总数
     * @param id
     * @return
     */
    int countByDynasty(int id);



    /**
     * 标题中含有title的诗词
     * @param title
     * @param page
     * @return
     */
    List<Poetry> findByTitle(String title, Page page);


    /**
     * 内容中含有content的诗词
     * @param
     * @return
     */
    List<Poetry> findByContent(String words, Page page);
}
