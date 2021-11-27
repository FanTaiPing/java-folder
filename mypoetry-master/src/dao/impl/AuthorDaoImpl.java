package dao.impl;

import dao.AuthorDao;
import dao.Dao;
import entity.Author;
import entity.Dynasty;
import entity.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljsy
 **/
public class AuthorDaoImpl extends Dao implements AuthorDao {



    /**
     * @return 所有诗人和词人
     */
    @Override
    public List<Author> findAll(int start, int limit) {
        List<Author> list = null;
        String sql = "select `id`, `name`, `dynasty` from `author` limit ?, ?";
        db.executeQuery(sql, Arrays.asList(start, limit));
        list = new ArrayList<>();
        while (db.next()) {
            Author author = new Author();
            author.setId(db.getInt(1));
            author.setName(db.getString(2));
//            author.setDynasty(db.getString(3));
            list.add(author);
        }
        return list;
    }

    /**
     * 拼音首字母找作者
     *
     * @param pinyin 拼音首字母
     * @param start  查询开始点
     * @param size   获取的数量
     * @return 姓名拼音以此字母开头的作者
     */
    @Override
    public List<Author> findAuthorByPinyin(String pinyin, int start, int size) {
        db.executeQuery("select `id`,`name` from `author` where `pinyin` = ? limit ?,?", Arrays.asList(pinyin,start,size));
        List<Author> list = new ArrayList<>();
        while (db.next()) {
            Author author = new Author();
            author.setId(db.getInt(1));
            author.setName(db.getString(2));
            list.add(author);
        }
        return list;
    }

    /**
     * 以朝代找作者
     *
     * @param id    朝代id
     * @param start 查询开始
     * @param size  返回长度
     * @return 作者数组
     */
    @Override
    public List<Author> findAuthorByDynasty(int id, int start, int size) {
        db.executeQuery("select `id`,`name` from `author` where `dynasty` = ? limit ?,?", Arrays.asList(id,start,size));
        List<Author> list = new ArrayList<>();
        while (db.next()) {
            Author author = new Author();
            author.setId(db.getInt(1));
            author.setName(db.getString(2));
            list.add(author);
        }
        return list;
    }



    /**
     * @param author 添加的作者
     * @return 成功的行数
     */
    @Override
    public int addAuthor(Author author) {
        List<Object> list = new ArrayList<>();
        list.add(author.getName());
        list.add(author.getDynasty());
        list.add(author.getLifeTime());
        list.add(author.getPinyin());
        return db.executeUpdate("insert into `author` (`name`,`dynasty`,`lifetime`,`pinyin`) value (?,?,?,?)", list);
    }

    /**
     * 所有作者数
     *
     * @return
     */
    @Override
    public int countAll() {
        db.executeQuery("select count(1) from `author`");
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 此朝代的所有作者
     *
     * @param id 朝代id
     * @return 作者总数
     */
    @Override
    public int countByDynasty(int id) {
        db.executeQuery("select count(1) from `author` where `dynasty` = ?", Arrays.asList(id));
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 以该字母为拼音开头的作者总数
     *
     * @param pinyin 拼音首字母
     * @return 作者总数
     */
    @Override
    public int countByPinyin(String pinyin) {

        db.executeQuery("select count(1) from `author` where `pinyin` = ?", Arrays.asList(pinyin));
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 以朝代和拼音找作者
     *
     * @param dynastyId
     * @param pinyin
     * @param from
     * @param size
     * @return
     */
    @Override
    public List<Author> findAuthorByDynastyAndPinyin(int dynastyId, String pinyin, int from, int size) {
        db.executeQuery("select `id`,`name` from `author` where `dynasty` = ? and `pinyin` = ? limit ?,?", Arrays.asList(dynastyId, pinyin, from, size));
        List<Author> list = new ArrayList<>();
        while (db.next()) {
            Author author = new Author();
            author.setId(db.getInt(1));
            author.setName(db.getString(2));
            list.add(author);
        }
        return list;
    }

    /**
     * 以id找作者, 没有则返回null
     *
     * @param authorId
     * @return
     */
    @Override
    public Author findById(int authorId) {
        db.executeQuery("select a.`id` , a.`name`,`pinyin`, `lifetime` , d.`id`, d.`dynasty_name` \n" +
                "from `author` as a inner join `dynasty`as d\n" +
                "on a.`dynasty` = d.`id` where a.`id` = ?", Arrays.asList(authorId));
        if (db.next()) {
            Author author = new Author();
            author.setId(db.getInt(1));
            author.setName(db.getString(2));
            author.setPinyin(db.getString(3));
            author.setLifeTime(db.getString(4));
            author.setDynasty(new Dynasty(db.getInt(5),db.getString(6)));
            return author;
        }
        return null;
    }

    /**
     * 此拼音和朝代的作者数
     *
     * @param dynastyId
     * @param pinyin
     * @return
     */
    @Override
    public int countByDynastyAndPinyin(int dynastyId, String pinyin) {
        db.executeQuery("select count(1) from `author` where `dynasty` = ? and `pinyin` = ?", Arrays.asList(dynastyId, pinyin));
        if (db.next()) {
            return db.getInt(1);
        }
        return 0;
    }

    /**
     * 该朝代的所有作者的拼音
     *
     * @param dynastyId
     * @return
     */
    @Override
    public List<String> findPinyinByDynasty(int dynastyId) {
        db.executeQuery("select distinct `pinyin` from `author` where `dynasty` = ? order by `pinyin`", Arrays.asList(dynastyId));
        List<String> list = new ArrayList<>();
        while(db.next()){
            list.add(db.getString(1));
        }
        return list;
    }

    /**
     * 名字中含有name的作者
     *
     * @param name
     * @param from
     * @param size
     * @return
     */
    @Override
    public List<Author> findAuthorByName(String name, int from, int size) {
        db.executeQuery("select `id`,`name`,`lifetime` from `author` where `name` like '%"+name+"%' limit ?,?", Arrays.asList(from,size));
        List<Author> list = new ArrayList<>();
        while (db.next()) {
            Author author = new Author();
            author.setId(db.getInt(1));
            author.setName(db.getString(2));
            author.setLifeTime(db.getString(3));
            list.add(author);
        }
        return list.isEmpty()?null:list;
    }


}
