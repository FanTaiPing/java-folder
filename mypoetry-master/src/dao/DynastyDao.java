package dao;

import entity.Dynasty;

import java.util.List;

/**
 * @author ljsy
 **/
public interface DynastyDao {
    /**
     * @return 所有朝代
     */
    List<Dynasty> findAll();

    /**
     * 有描述的朝代对象
     * @param id 朝代id
     * @return
     */
    Dynasty findById(int id);
}
