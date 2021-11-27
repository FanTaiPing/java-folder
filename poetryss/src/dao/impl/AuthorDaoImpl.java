package dao.impl;

import dao.AuthorDao;
import dao.Dao;
import entity.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author y
 */
public class AuthorDaoImpl extends Dao implements AuthorDao {
    @Override
    public List<Author> findAllAuthor(int start, int rows) {
        List<Author> list = null;
        String sql = "select id,`name`,dynasty,lifetime,pinyin from author limit ?,?";
        db.executeQuery(sql,Arrays.asList(start,rows));
        list = new ArrayList<Author>();
        while(db.next()){
            Author author = new Author();
            author.setId(db.getInt(1));
            author.setName(db.getString(2));
            author.setDynasty(db.getInt(3));
            author.setLifeTime(db.getString(4));
            author.setPinyin(db.getString(5));
            list.add(author);
        }
        return list;
    }

    @Override
    public int countAuthor() {
        int count = 0;
        String sql = "select count(1) from author;";
        db.executeQuery(sql);
        if(db.next()){
            count = db.getInt(1);
        }
        return count;
    }

    @Override
    public Author findIdByName(String name) {
        Author author = null;
        String sql = "select id from author where `name` =?";
        db.executeQuery(sql,Arrays.asList(name));
        if(db.next()){
            author = new Author();
            author.setId(db.getInt(1));
        }
        return author;
    }

    @Override
    public int deleteAuthorById(int id) {
        String sql = "delete from `author` where id =?";
        return db.executeUpdate(sql,Arrays.asList(id));
    }
}
