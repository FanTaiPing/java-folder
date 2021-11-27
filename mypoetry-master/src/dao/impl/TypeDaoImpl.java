package dao.impl;

import dao.Dao;
import dao.TypeDao;
import entity.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljsy
 **/
public class TypeDaoImpl extends Dao implements TypeDao {
    /**
     * 所有类型
     *
     * @param from 开始位置
     * @param size  获取数据的数量
     * @return 所有类型
     */
    @Override
    public List<Type> findAll(int from, int size) {
        List<Type> list = new ArrayList<>();
        db.executeQuery("select `id`,`type_name` from `type` limit ?,?", Arrays.asList(from,size));
        while (db.next()){
            Type type = new Type(db.getInt(1),db.getString(2));
            list.add(type);
        }
        return list;
    }

    /**
     * 返回该作者的诗词的所有类型
     *
     * @param id    作者id
     * @param start
     * @param size
     * @return
     */
    @Override
    public List<Type> findByAuthor(int id, int start, int size) {
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
        db.executeQuery("select `id`,`type_name` from `type` where `id` =?", Arrays.asList(typeId));
        if (db.next()) {
            return new Type(db.getInt(1), db.getString(2));
        }
        return null;
    }

    /**
     * 所有类型的总数
     *
     * @return
     */
    @Override
    public int countAll() {
        db.executeQuery("select count(1) from `type`");
        if(db.next()){
            return db.getInt(1);
        }
        return 0;
    }
}
