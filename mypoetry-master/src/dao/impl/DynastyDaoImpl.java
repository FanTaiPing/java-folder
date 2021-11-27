package dao.impl;

import dao.Dao;
import dao.DynastyDao;
import entity.Dynasty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljsy
 **/
public class DynastyDaoImpl extends Dao implements DynastyDao {
    /**
     * @return 所有朝代
     */
    @Override
    public List<Dynasty> findAll() {
        List<Dynasty> list = null;
        db.executeQuery("select `id`,`dynasty_name` from `dynasty`");
        list = new ArrayList<>();
        while (db.next()){
            Dynasty dynasty = new Dynasty();
            dynasty.setId(db.getInt(1));
            dynasty.setDynastyName(db.getString(2));
            list.add(dynasty);
        }
        return list;
    }

    /**
     * 有描述的朝代对象
     *
     * @param id 朝代id
     * @return
     */
    @Override
    public Dynasty findById(int id) {
        Dynasty dynasty= null;
        db.executeQuery("select `id`,`dynasty_name`,`description` from `dynasty` where `id` = ?", Arrays.asList(id));
        dynasty = new Dynasty();
        if(db.next()) {
            dynasty.setId(db.getInt(1));
            dynasty.setDynastyName(db.getString(2));
            dynasty.setDescribe(db.getString(3));
        }
        return dynasty;
    }
}
