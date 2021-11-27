package dao.impl;

import dao.Dao;
import dao.PoetryDao;
import entity.Author;
import entity.Poetry;
import entity.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author y
 */
public class PoetryDaoImpl extends Dao implements PoetryDao {
    @Override
    public List<Poetry> findAllPoetry(int start, int rows) {
        List<Poetry> list = null;
        String sql = "select p.id,\n" +
                "p.title,\n" +
                "a.`name`,\n" +
                "p.content,\n" +
                "t.type_name \n" +
                "from author as a \n" +
                "inner join poetry as p \n" +
                "on a.id = p.author \n" +
                "inner join type as t \n" +
                "on p.type = t.id limit ?,?";
        db.executeQuery(sql, Arrays.asList(start, rows));
        list = new ArrayList<Poetry>();
        while (db.next()) {
            Poetry poetry = new Poetry();
            poetry.setId(db.getInt(1));
            poetry.setTitle(db.getString(2));
            Author author = new Author();
            author.setName(db.getString(3));
            poetry.setAuthor(author);
            poetry.setContent(db.getString(4));
            Type type = new Type();
            type.setTypeName(db.getString(5));
            poetry.setType(type);
            list.add(poetry);
        }
        return list;
    }

    @Override
    public int countPoetry() {
        int count = 0;
        String sql = "select count(1) from poetry";
        db.executeQuery(sql);
        if (db.next()) {
            count = db.getInt(1);
        }
        return count;
    }

    @Override
    public Poetry findPoetryById(int id) {
        Poetry poetry = null;
        String sql = "select p.id,\n" +
                "p.title,\n" +
                "a.`name`,\n" +
                "p.content,\n" +
                "p.translate,\n" +
                "p.translate_res,\n" +
                "p.notes,\n" +
                "p.appreciation,\n" +
                "p.appreciation_res,\n" +
                "t.type_name \n" +
                "from poetry as p \n" +
                "inner join author as a \n" +
                "on p.author = a.id \n" +
                "inner join type as t \n" +
                "on p.type = t.id \n" +
                "where p.id = ?";
        db.executeQuery(sql, Arrays.asList(id));
        while (db.next()) {
            poetry = new Poetry();
            poetry.setId(db.getInt(1));
            poetry.setTitle(db.getString(2));

            Author author = new Author();
            author.setName(db.getString(3));
            poetry.setAuthor(author);

            poetry.setContent(db.getString(4));
            poetry.setTranslate(db.getString(5));
            poetry.setTranslate_res(db.getString(6));
            poetry.setNotes(db.getString(7));
            poetry.setAppreciation(db.getString(8));
            poetry.setAppreciation_res(db.getString(9));

            Type type = new Type();
            type.setTypeName(db.getString(10));
            poetry.setType(type);
        }
        return poetry;
    }

    @Override
    public int deletePoetryById(int id) {
        String sql = "delete from poetry where id = ?";
        return db.executeUpdate(sql, Arrays.asList(id));
    }

    @Override
    public int addPoetry(Poetry poetry) {
        String sql = "insert into poetry(id,title,author,content,translate,translate_res,notes,appreciation,appreciation_res,type) values(?,?,?,?,?,?,?,?,?,?)";
        return db.executeUpdate(sql, Arrays.asList(poetry));
    }

    @Override
    public int updatePoetry(Poetry poetry) {
        String sql = "update poetry set title=?,author=?,content=?,translate=?,translate_res=?,notes=?,appreciation=?,appreciation_res=?,type=? where id = ?";
        return db.executeUpdate(sql, Arrays.asList(poetry));
    }
}
