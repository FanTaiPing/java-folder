package service.impl;

import dao.AuthorDao;
import dao.impl.AuthorDaoImpl;
import entity.Author;
import entity.Page;
import service.AuthorService;

import java.util.List;

/**
 * @author ljsy
 **/
public class AuthorServiceImpl implements AuthorService {

    AuthorDao authorDao = new AuthorDaoImpl();


    /**
     * 以该字母为拼音开头的作者总数
     *
     * @param pinyin 拼音首字母
     * @return 作者总数
     */
    @Override
    public int countByPinyin(String pinyin) {
        return authorDao.countByPinyin(pinyin);
    }

    /**
     * 此朝代的所有作者
     *
     * @param id 朝代id
     * @return 作者总数
     */
    @Override
    public int countByDynasty(int id) {
        return authorDao.countByDynasty(id);
    }

    /**
     * 带分页的所有作者
     *
     * @param page
     * @return 所有诗人和词人
     */
    @Override
    public List<Author> findAll(Page page) {
        return authorDao.findAll(page.getFrom(), page.getSize());
    }

    /**
     * 拼音首字母找作者
     *
     * @param pinyin 拼音首字母
     * @param page
     * @return 姓名拼音以此字母开头的作者
     */
    @Override
    public List<Author> findAuthorByPinyin(String pinyin, Page page) {
        return authorDao.findAuthorByPinyin(pinyin, page.getFrom(), page.getSize());
    }

    /**
     * 以朝代找作者
     *
     * @param id   朝代id
     * @param page
     * @return 作者数组
     */
    @Override
    public List<Author> findAuthorByDynasty(int id, Page page) {
        return authorDao.findAuthorByDynasty(id, page.getFrom(), page.getSize());
    }

    /**
     * 以朝代和拼音找作者
     *
     * @param dynastyId 朝代id
     * @param pinyin    拼音
     * @param page      页数
     * @return 作者
     */
    @Override
    public List<Author> findAuthorByDynastyAndPinyin(int dynastyId, String pinyin, Page page) {
        return authorDao.findAuthorByDynastyAndPinyin(dynastyId, pinyin, page.getFrom(), page.getSize());
    }

    /**
     * 以id找作者, 没有则返回null
     *
     * @param authorId
     * @return
     */
    @Override
    public Author findAuthorById(int authorId) {
        return authorDao.findById(authorId);
    }

    /**
     * 所有作者数
     *
     * @return
     */
    @Override
    public int countAll() {
        return authorDao.countAll();
    }

    /**
     * 此拼音和朝代的作者数
     *
     * @param dynastyId
     * @param pinyin
     * @return
     */
    @Override
    public int countByDynastyAndPinyin(int dynastyId, String pinyin) {
        return authorDao.countByDynastyAndPinyin(dynastyId, pinyin);
    }

    /**
     * 该朝代的所有作者的拼音
     *
     * @param dynastyId
     * @return
     */
    @Override
    public List<String> findPinyinByDynasty(int dynastyId) {
        return authorDao.findPinyinByDynasty(dynastyId);
    }

    /**
     * 名字中含有name的作者
     *
     * @param name
     * @param page
     * @return
     */
    @Override
    public List<Author> findAuthorByName(String name, Page page) {
        return authorDao.findAuthorByName(name, page.getFrom(), page.getSize());
    }
}
