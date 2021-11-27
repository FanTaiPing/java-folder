package dao.impl;
import dao.Dao;
import dao.UserDao;
import entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author y
 */
public class UserDaoImpl extends Dao implements UserDao {

    @Override
    public List<User> findAllUser(int start, int rows) {
        List<User> list = null;
        String sql = "select id,username,`password`,userImg from `user` limit ?,?";
        db.executeQuery(sql,Arrays.asList(start,rows));
        list = new ArrayList<User>();
        while(db.next()){
            User user = new User();
            user.setId(db.getInt(1));
            user.setUsername(db.getString(2));
            user.setPassword(db.getString(3));
            user.setUserImg(db.getString(4));
            list.add(user);
        }
        return list;
    }

    /**
     * @param user 用户对象
     * @return 返回int值，判断是否插入数据成功
     */
    @Override
    public int addUser(User user) {

        String sql = "insert into `user`(username,`password`) values(?,?)";
        return db.executeUpdate(sql, Arrays.asList(user.getUsername(), user.getPassword()));
    }

    /**
     * @param username 用户名
     * @return 返回查询到的 user 对象
     */
    @Override
    public User isExitsUser(String username) {
        User user = null;
        String sql = "select id,username,`password` from `user` where username =?";
        db.executeQuery(sql, Arrays.asList(username));
        if (db.next()) {
            user = new User();
            user.setId(db.getInt(1));
            user.setUsername(db.getString(2));
            user.setPassword(db.getString(3));
        }
        return user;
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = null;
        String sql = "select id,username,`password`,userImg from `user` where username =? and password =?";
        db.executeQuery(sql,Arrays.asList(username,password));
        if(db.next()) {
            user = new User();
            user.setId(db.getInt(1));
            user.setUsername(db.getString(2));
            user.setPassword(db.getString(3));
            user.setUserImg(db.getString(4));
        }
        return user;
    }

    @Override
    public int countUser() {
        int count =0;
        String sql = "select count(1) from `user`";
        db.executeQuery(sql);
        if(db.next()){
            count = db.getInt(1);
        }
        return count;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update `user` set username=?,`password`=?,userImg=? where id =?";
        return db.executeUpdate(sql,Arrays.asList(user.getUsername(),user.getPassword(),user.getUserImg(),user.getId()));
    }

    @Override
    public User FindUserByIdServlet(int id) {
        User user= null;
        String sql = "select id,username,`password`,userImg from `user` where id=?";
        db.executeQuery(sql,Arrays.asList(id));
        if(db.next()){
            user = new User();
            user.setId(db.getInt(1));
            user.setUsername(db.getString(2));
            user.setPassword(db.getString(3));
            user.setUserImg(db.getString(4));
        }
        return user;
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "delete from `user` where id =?";
        return db.executeUpdate(sql,Arrays.asList(id));
    }
}
