package service.impl;

import dao.DynastyDao;
import dao.impl.DynastyDaoImpl;
import entity.Dynasty;
import service.DynastyService;

import java.util.List;

/**
 * @author ljsy
 **/
public class DynastyServiceImpl implements DynastyService {
    DynastyDao dynastyDao = new DynastyDaoImpl();

    /**
     * @return 所有朝代
     */
    @Override
    public List<Dynasty> findAll() {
        return dynastyDao.findAll();
    }

    /**
     * 有描述的朝代对象
     *
     * @param id 朝代id
     * @return
     */
    @Override
    public Dynasty findById(int id) {
        return dynastyDao.findById(id);
    }
}
