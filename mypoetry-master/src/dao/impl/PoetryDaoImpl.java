package dao.impl;

import dao.Dao;
import dao.PoetryDao;
import entity.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljsy
 **/
public class PoetryDaoImpl extends Dao implements PoetryDao {

    /**
     * 使用前先执行db.executeQuery()方法
     * 通过db.next()获得以查询的所有诗词, 不含解释
     *
     * @return 数据为空时返回null
     */
    private List<Poetry> getPoetryInfosFromDb() {
        List<Poetry> list = new ArrayList<>();
        while (db.next()) {
            Poetry poetry = new Poetry();
            poetry.setId(db.getInt(1));
            poetry.setTitle(db.getString(2));
            poetry.setContent(db.getString(3));

            Author author = new Author();
            author.setId(db.getInt(4));
            author.setName(db.getString(5));

            Dynasty dynasty = new Dynasty();
            dynasty.setId(db.getInt(6));
            dynasty.setDynastyName(db.getString(7));
            author.setDynasty(dynasty);
            poetry.setAuthor(author);

            list.add(poetry);
        }
        return list.isEmpty() ? null : list;
    }


    /**
     * 返回指定起点和长度的诗词数组
     *
     * @param start id开始点
     * @param from  limit开始
     * @param size  返回集合长度
     * @return size个诗词
     */
    @Override
    public List<Poetry> findAll(int start, int from, int size) {
        List<Poetry> list = null;
        String sql = "select p.`id`, p.`title`, p.`content`,p.`translate`,p.`translate_res`,p.`notes`,p.`appreciation`,p.`appreciation_res`, a.`id`, a.`name`, a.`lifetime`, d.`id`, d.`dynasty_name` \n" +
                "from `poetry` as p\n" +
                "inner join `author` as a\n" +
                "on p.`author` = a.`id`\n" +
                "inner join `dynasty` as d\n" +
                "on a.`dynasty` = d.`id`\n" +
                "where p.`id` > ?\n" +
                "limit ?, ?";
        db.executeQuery(sql, Arrays.asList(start, from, size));
        list = new ArrayList<>();
        while (db.next()) {
            Poetry poetry = new Poetry();
            poetry.setId(db.getInt(1));
            poetry.setTitle(db.getString(2));
            poetry.setContent(db.getString(3));
            poetry.setTranslate(db.getString(4));
            poetry.setTranslateRes(db.getString(5));
            poetry.setNotes(db.getString(6));
            poetry.setAppreciation(db.getString(7));
            poetry.setAppreciationRes(db.getString(8));

            Author author = new Author();
            author.setId(db.getInt(9));
            author.setName(db.getString(10));
            author.setLifeTime(db.getString(11));

            Dynasty dynasty = new Dynasty();
            dynasty.setId(db.getInt(12));
            dynasty.setDynastyName(db.getString(13));
            author.setDynasty(dynasty);
            poetry.setAuthor(author);

            list.add(poetry);
        }
        return list;
    }


    /**
     * 通过朝代找诗词
     *
     * @param id   朝代id
     * @param from
     * @param size
     * @return
     */
    @Override
    public List<Poetry> findByDynasty(int id, int from, int size) {
        String sql = "select p.`id`, `title`, `content`, a.`id`, a.`name`, d.`id`,d.`dynasty_name`\n" +
                "from `poetry` as p\n" +
                "inner join `author` as a\n" +
                "on `author` = a.`id`\n" +
                "inner join `dynasty` as d\n" +
                "on a.`dynasty` = d.`id`\n" +
                "where a.`dynasty` = ?\n" +
                "limit ?,?";
        db.executeQuery(sql, Arrays.asList(id, from, size));

        return getPoetryInfosFromDb();
    }

    /**
     * 通过作者找诗词
     *
     * @param id   作者id
     * @param from
     * @param size
     * @return
     */
    @Override
    public List<Poetry> findByAuthor(int id, int from, int size) {
        String sql = "select p.`id`, `title`, `content`, a.`id`, a.`name`, d.`id`,d.`dynasty_name`\n" +
                "from `poetry` as p\n" +
                "inner join `author` as a\n" +
                "on `author` = a.`id`\n" +
                "inner join `dynasty` as d\n" +
                "on a.`dynasty` = d.`id`\n" +
                "where a.`id` = ?\n" +
                "limit ?,?";
        db.executeQuery(sql, Arrays.asList(id, from, size));
        return getPoetryInfosFromDb();
    }

    /**
     * 通过类型找诗词
     *
     * @param id   类型id
     * @param from
     * @param size
     * @return
     */
    @Override
    public List<Poetry> findByType(int id, int from, int size) {
        String sql = "select p.`id`, p.`title`, p.`content`, a.`id`, a.`name`, d.`id`, d.`dynasty_name` \n" +
                "from `poetry` as p\n" +
                "inner join `author` as a\n" +
                "on p.`author` = a.`id`\n" +
                "inner join `dynasty` as d\n" +
                "on a.`dynasty` = d.`id`\n" +
                "where p.`type` = ?\n" +
                "limit ?, ?";
        db.executeQuery(sql, Arrays.asList(id, from, size));
        return getPoetryInfosFromDb();
    }



    /**
     * 所有诗词总数
     *
     * @return
     */
    @Override
    public int countAll() {
        db.executeQuery("select count(1) from `poetry`");
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 该朝代的诗词总数
     *
     * @param id
     * @return
     */
    @Override
    public int countByDynasty(int id) {
        db.executeQuery("select count(1) \n" +
                "from `poetry` \n" +
                "inner join `author` as a\n" +
                "on `author` = a.`id`\n" +
                "where a.`dynasty` = ?", Arrays.asList(id));
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 作者的作品数
     *
     * @param authorId
     * @return
     */
    @Override
    public int countByAuthor(int authorId) {
        db.executeQuery("select count(1) from `poetry` where `author` = ?", Arrays.asList(authorId));
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 通过id找诗词
     *
     * @param poetryId
     * @return
     */
    @Override
    public Poetry findById(int poetryId) {
        String sql = "select p.`id`, p.`title`, p.`content`,p.`translate`,p.`translate_res`,p.`notes`,p.`appreciation`,p.`appreciation_res`, a.`id`, a.`name`, a.`lifetime`, d.`id`, d.`dynasty_name` , t.`id`,t.`type_name`\n" +
                "from `poetry` as p\n" +
                "inner join `author` as a\n" +
                "on p.`author` = a.`id`\n" +
                "inner join `dynasty` as d\n" +
                "on a.`dynasty` = d.`id`\n" +
                "inner join `type` as t\n" +
                "on p.`type` = t.`id`\n" +
                "where p.`id` = ?";
        db.executeQuery(sql, Arrays.asList(poetryId));
        if (db.next()) {
            Poetry poetry = new Poetry();
            poetry.setId(db.getInt(1));
            poetry.setTitle(db.getString(2));
            poetry.setContent(db.getString(3));
            poetry.setTranslate(db.getString(4));
            poetry.setTranslateRes(db.getString(5));
            poetry.setNotes(db.getString(6));
            poetry.setAppreciation(db.getString(7));
            poetry.setAppreciationRes(db.getString(8));

            Author author = new Author();
            author.setId(db.getInt(9));
            author.setName(db.getString(10));
            author.setLifeTime(db.getString(11));

            Dynasty dynasty = new Dynasty();
            dynasty.setId(db.getInt(12));
            dynasty.setDynastyName(db.getString(13));
            author.setDynasty(dynasty);
            poetry.setAuthor(author);

            Type type = new Type(db.getInt(14), db.getString(15));
            poetry.setType(type);
            return poetry;
        }
        return null;
    }

    /**
     * 同类型诗词计数
     *
     * @param id
     * @return
     */
    @Override
    public int countByType(int id) {
        db.executeQuery("select count(1) from `poetry` where `type` = ?", Arrays.asList(id));
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 标题中含有title的诗词
     *
     * @param title
     * @param from
     * @param size
     * @return
     */
    @Override
    public List<Poetry> findByTitle(String title, int from, int size) {
        String sql = "select p.`id`, p.`title`, p.`content`, a.`id`, a.`name`, d.`id`, d.`dynasty_name` \n" +
                "from `poetry` as p\n" +
                "inner join `author` as a\n" +
                "on p.`author` = a.`id`\n" +
                "inner join `dynasty` as d\n" +
                "on a.`dynasty` = d.`id`\n" +
                "where p.`title` like '%"+title+"%' \n" +
                "limit ?, ?";
        db.executeQuery(sql, Arrays.asList(from, size));
        return getPoetryInfosFromDb();
    }

    /**
     * 内容中含有content的诗词
     *
     * @param content
     * @param from
     * @param size
     * @return
     */
    @Override
    public List<Poetry> findByContent(String content, int from, int size) {
        String sql = "select p.`id`, p.`title`, p.`content`, a.`id`, a.`name`, d.`id`, d.`dynasty_name` \n" +
                "from `poetry` as p\n" +
                "inner join `author` as a\n" +
                "on p.`author` = a.`id`\n" +
                "inner join `dynasty` as d\n" +
                "on a.`dynasty` = d.`id`\n" +
                "where p.`content` like '%"+content+"%' \n" +
                "limit ?, ?";
        db.executeQuery(sql, Arrays.asList(from, size));
        return getPoetryInfosFromDb();
    }
}
