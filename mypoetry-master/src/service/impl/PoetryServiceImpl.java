package service.impl;

import dao.PoetryDao;
import dao.impl.PoetryDaoImpl;
import entity.Page;
import entity.Poetry;
import service.PoetryService;

import java.util.List;

/**
 * @author ljsy
 **/
public class PoetryServiceImpl implements PoetryService {
    PoetryDao poetryDao = new PoetryDaoImpl();


    /**
     * 搜索词搜索的结果
     *
     * @param word 搜索词
     * @param page
     * @return
     */
    @Override
    public List<Poetry> searchPoetry(String word, Page page) {
        return null;
    }

    /**
     * 返回指定id开始的诗词数组
     *
     * @param start 返回的诗词的id将大于start
     * @param page
     * @return 诗词
     */
    @Override
    public List<Poetry> findAll(int start, Page page) {
        return poetryDao.findAll(start, page.getFrom(), page.getSize());
    }


    /**
     * 通过朝代找诗词
     *
     * @param id   朝代id
     * @param page
     * @return
     */
    @Override
    public List<Poetry> findByDynasty(int id, Page page) {
        return poetryDao.findByDynasty(id, page.getFrom(), page.getSize());
    }

    /**
     * 通过作者找诗词
     *
     * @param id   作者id
     * @param page
     * @return
     */
    @Override
    public List<Poetry> findByAuthor(int id, Page page) {
        return poetryDao.findByAuthor(id,page.getFrom(),page.getSize());
    }

    /**
     * 通过类型找诗词
     *
     * @param id   类型id
     * @param page
     * @return
     */
    @Override
    public List<Poetry> findByType(int id, Page page) {
        return poetryDao.findByType(id,page.getFrom(),page.getSize());
    }

    /**
     * 通过作者和类型找诗词
     *
     * @param authorId
     * @param typeId
     * @param page
     * @return
     */
    @Override
    public List<Poetry> findByAuthorAndType(int authorId, int typeId, Page page) {
        return null;
    }

    /**
     * 作者的作品数
     *
     * @param authorId
     * @return
     */
    @Override
    public int countByAuthor(int authorId) {
        return poetryDao.countByAuthor(authorId);
    }

    /**
     * 通过id找诗词
     *
     * @param poetryId
     * @return
     */
    @Override
    public Poetry findById(int poetryId) {
        return poetryDao.findById(poetryId);
    }

    /**
     * 同类型诗词计数
     *
     * @param id
     * @return
     */
    @Override
    public int countByType(int id) {
        return poetryDao.countByType(id);
    }

    /**
     * 所有诗词总数
     *
     * @return
     */
    @Override
    public int countAll() {
        return poetryDao.countAll();
    }

    /**
     * 该朝代的诗词总数
     *
     * @param id
     * @return
     */
    @Override
    public int countByDynasty(int id) {
        return poetryDao.countByDynasty(id);
    }

    /**
     * 标题中含有title的诗词
     *
     * @param title
     * @param page
     * @return
     */
    @Override
    public List<Poetry> findByTitle(String title, Page page) {
        return poetryDao.findByTitle(title,page.getFrom(),page.getSize());
    }

    /**
     * 内容中含有content的诗词
     *
     * @param content
     * @param page
     * @return
     */
    @Override
    public List<Poetry> findByContent(String content, Page page) {
        return poetryDao.findByContent(content,page.getFrom(),page.getSize());
    }
}
