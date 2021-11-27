package service.impl;

import dao.TypeDao;
import dao.impl.TypeDaoImpl;
import entity.Page;
import entity.Type;
import service.TypeService;

import java.util.List;

/**
 * @author ljsy
 **/
public class TypeServiceImpl implements TypeService {

    TypeDao typeDao = new TypeDaoImpl();


    /**
     * 所有类型
     *
     * @param page
     * @return 所有类型
     */
    @Override
    public List<Type> findAll(Page page) {
        return typeDao.findAll(page.getFrom(),page.getSize());
    }

    /**
     * 返回该作者的诗词的所有类型
     *
     * @param id   作者ide
     * @param page
     * @return
     */
    @Override
    public List<Type> findByAuthor(int id, Page page) {
        return null;
    }

    /**
     * 该作者的所有诗词的所有类型
     *
     * @param id 作者id
     * @return
     */
    @Override
    public int typeForAuthorCount(int id) {
        return 0;
    }

    /**
     * 以id找类型
     *
     * @param typeId
     * @return
     */
    @Override
    public Type findById(int typeId) {
        return typeDao.findById(typeId);
    }

    /**
     * 所有类型的总数
     *
     * @return
     */
    @Override
    public int countAll() {
        return typeDao.countAll();
    }
}
