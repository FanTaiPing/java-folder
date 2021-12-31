import com.fan.dao.EmpDao;
import com.fan.service.EmpService;
import com.fan.service.impl.EmpServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpService {
    @Test
    public void testAutoDI() {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationTwo.xml");
        EmpService empService = (EmpService) context.getBean("empService");
        System.out.println(empService.getEmpById(1));
    }

    @Test
    public void testSingleton() throws Exception {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationTwo.xml");
        //获得bean
        EmpService empServiceOne = (EmpService) context.getBean("empService");
        EmpService empServiceTwo = (EmpService) context.getBean("empService");
        //查看对象（工厂bean默认单例）
        System.out.println(empServiceOne);
        System.out.println(empServiceTwo);

        //bean标签原理：反射+构造方法
        EmpService empService = (EmpService) Class.forName("com.fan.service.impl.EmpServiceImpl").newInstance();
        System.out.println(empService);
        EmpDao empDao = (EmpDao) Class.forName("com.fan.dao.impl.EmpDaoImpl").newInstance();
       //父类转子类，强制转换
        ((EmpServiceImpl) empService).setEmpDaoTwo(empDao);
        System.out.println(empService.getEmpById(2));
    }
    @Test
public void testLifeCycle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationTwo.xml");
        EmpService empService = (EmpService) context.getBean("empService");

        //用完后销毁
        ((ClassPathXmlApplicationContext)context).close();
}
}
