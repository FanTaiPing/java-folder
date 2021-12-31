import com.fan.dao.UserDao;
import com.fan.entity.User;
import com.fan.utils.DBHelperUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;


public class TestUser {
    private DBHelperUser db = new DBHelperUser();
    private SqlSession sqlSession = null;
    static Logger logger = Logger.getLogger(TestUser.class);

    @Test
    public void testFindAllUser() {
        try {
            sqlSession = db.openDB();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.findAllUser().forEach(System.out::println);
            //手动提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession 对象
            db.closeDB();
        }
    }

    @Test
    public void testGetUserById() {
        try {
            sqlSession = db.openDB();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUserById(5);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeDB();
        }
    }

    @Test
    public void testGetUserByIdAndName() {
        try {
            sqlSession = db.openDB();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUserByIdAndName(5, "孙尚香");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeDB();
        }
    }
    /**
     *-------------------------------------------------------------------------
     *用于测试打印log日志文件的测试方法
     *-------------------------------------------------------------------------
     */
    @Test
    public void count() {
        logger.info("进入了log4j的test中");
        try {
            sqlSession = db.openDB();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            System.out.println("共有用户数据"+userDao.count()+"条");
            logger.debug("debug:进入了testLog4j");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.error("error:进入了testLog4j");
            db.closeDB();
        }
    }
    @Test
    public void testInsertUser() {
        try {
            sqlSession = db.openDB();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User();
            user.setName("虞姬");
            user.setBir(new Date());
            user.setAddress("四川成都");
            user.setSex('女');
            userDao.insertUser(user);
            //手动提交事务
            sqlSession.commit();
            //调用查询方法
            testFindAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeDB();
        }
    }
    @Test
    public void testDeleteUser(){
        try {
            sqlSession = db.openDB();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User();
            user.setId(5);
            userDao.deleteUser(user);
            //手动提交事务
            sqlSession.commit();
            //调用查询方法
            testFindAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeDB();
        }
    }
    @Test
    public void testUpdateUser(){
        try {
            sqlSession = db.openDB();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User();
            user.setId(5);
            user.setName("妲己");
            user.setBir(new Date());
            user.setAddress("四川重庆");
            user.setSex('女');
            userDao.updateUser(user);
            //手动提交事务
            sqlSession.commit();
            //调用查询方法
            testFindAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeDB();
        }
    }
}
