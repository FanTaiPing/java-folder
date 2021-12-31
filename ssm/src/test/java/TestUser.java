import com.fan.dao.UserDao;
import com.fan.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

public class TestUser {
//    @Test
//    public void testLogin() throws IOException {
//        Reader reader = Resources.getResourceAsReader("spring-mybatis.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        User u = new User();
//        u.setName("刘备");
//        u.setPassword("123456");
//        System.out.println(userDao.login(u));
//    }
}
