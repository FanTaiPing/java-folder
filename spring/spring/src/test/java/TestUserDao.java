import com.fan.dao.UserDao;
import com.fan.dao.impl.UserDaoImpl;
import com.fan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    /**
     * 原来JDBC是创建对象调用方法
     */
    private UserDao userDao = new UserDaoImpl();
    private UserDao uDao;

    //    /**
//     * SET注入
//     * @param userDao
//     */
//    public void setUserDao(UserDao userDao){
//    this.userDao = userDao;
//}
    @Test
    public void testSave() {
        userDao.save("东方闪电");
    }

    @Test
    public void testSpringSave() {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //获取当前UserDao对象
        UserDao userDao = (UserDao) context.getBean("uDao");
        userDao.save("大是大非");
    }

    @Test
    public void testSpringService() {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.save("浮动的");

    }
}
