package dao.impl;

import dao.Dao;
import dao.TypeDao;
import entity.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author y
 */
public class TypeDaoImpl extends Dao implements TypeDao {
    @Override
    public List<Type> findAllType(int start, int rows) {
        List<Type> list = null;
        String sql = "select id,type_name from type limit ?,?";
        db.executeQuery(sql, Arrays.asList(start,rows));
        list = new ArrayList<Type>();
        while(db.next()){
            Type type = new Type();
            type.setId(db.getInt(1));
            type.setTypeName(db.getString(2));
            list.add(type);
        }
        return list;
    }

    @Override
    public int countType() {
        int count =0;
        String sql = "select count(1) from type";
        db.executeQuery(sql);
        if(db.next()){
            count = db.getInt(1);
        }
        return count;
    }

    @Override
    public Type findIdByName(String type_name) {
        Type type = null;
        String sql = "select id from type where type_name =?";
        db.executeQuery(sql,Arrays.asList(type_name));
        if(db.next()){
            type = new Type();
            type.setId(db.getInt(1));
        }
        return type;
    }
}
