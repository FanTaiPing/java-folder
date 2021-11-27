package dao;

import entity.Author;
import entity.Page;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author ljsy
 **/
public interface AuthorDao {

    /**
     * 带分页
     *
     * @return 所有诗人和词人
     */
    List<Author> findAll(int start, int size);

    /**
     * 拼音首字母找作者
     *
     * @param pinyin 拼音首字母
     * @param start 查询开始点
     * @param size  获取的数量
     * @return 姓名拼音以此字母开头的作者
     */
    List<Author> findAuthorByPinyin(String pinyin, int start, int size);

    /**
     * 以朝代找作者
     * @param id 朝代id
     * @param start 查询开始
     * @param size 返回长度
     * @return 作者数组
     */
    List<Author> findAuthorByDynasty(int id , int start, int size);



    /**
     * 添加作者
     *
     * @param author 添加的作者
     * @return 成功的行数
     */
    int addAuthor(Author author);

    /**
     * 所有作者数
     * @return
     */
    int countAll();

    /**
     * 此朝代的所有作者
     * @param id 朝代id
     * @return 作者总数
     */
    int countByDynasty(int id);

    /**
     * 以该字母为拼音开头的作者总数
     *
     * @param pinyin 拼音首字母
     * @return 作者总数
     */
    int countByPinyin(String pinyin);

    /**
     * 以朝代和拼音找作者
     * @param dynastyId
     * @param pinyin
     * @param from
     * @param size
     * @return
     */
    List<Author> findAuthorByDynastyAndPinyin(int dynastyId, String pinyin, int from, int size);

    /**
     * 以id找作者, 没有则返回null
     *
     * @param authorId
     * @return
     */
    Author findById(int authorId);

    /**
     * 此拼音和朝代的作者数
     *
     * @param dynastyId
     * @param pinyin
     * @return
     */
    int countByDynastyAndPinyin(int dynastyId, String pinyin);

    /**
     * 该朝代的所有作者的拼音
     * @param dynastyId
     * @return
     */
    List<String> findPinyinByDynasty(int dynastyId);

    /**
     * 名字中含有name的作者
     *
     * @param name
     * @return
     */
    List<Author> findAuthorByName(String name, int from, int size);
}
