package dao.impl;

import dao.Dao;
import dao.DynastyDao;
import entity.Dynasty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author y
 */
public class DynastyDaoImpl extends Dao implements DynastyDao {
    @Override
    public List<Dynasty> findAllDynasty(int start, int rows) {
        List<Dynasty> list = null;
        String sql = "select id,dynasty_name,description from dynasty limit ?,?";
        db.executeQuery(sql, Arrays.asList(start,rows));
        list = new ArrayList<Dynasty>();
        while(db.next()){
            Dynasty dynasty = new Dynasty();
            dynasty.setId(db.getInt(1));
            dynasty.setDynastyName(db.getString(2));
            dynasty.setDescribe(db.getString(3));
            list.add(dynasty);
        }
        return list;
    }

    @Override
    public int countDynasty() {
        int count = 0;
        String sql = "select count(1) from dynasty";
        db.executeQuery(sql);
        if(db.next()){
            count = db.getInt(1);
        }
        return count;
    }

    @Override
    public int deleteDynastyById(int id) {
        String sql = "delete from `dynasty` where id =?";
        return db.executeUpdate(sql,Arrays.asList(id));
    }
}
