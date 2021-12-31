import com.fan.dao.EmpDao;
import com.fan.entity.Emp;
import com.fan.utils.DBHelper;
import com.fan.utils.ThreadLocalHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;

public class TestMybatis {
    private SqlSession sqlSession;

    @Test
    public void testMybatis() {
        try {
            //读取mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            //创建mybatis核心对象sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //获取SqlSession(不带参数<代表事务手动提交>，openSession(true)代表事务自动提交)
            sqlSession = sqlSessionFactory.openSession();
            //打印对象信息
            System.out.println(sqlSession);
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            empDao.findAll().forEach(System.out::println);
            //关闭sqlSession对象
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmpById() {
        try {
//            InputStream is = Resources.getResourceAsStream("mybatis.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//            sqlSession = sqlSessionFactory.openSession();
            sqlSession = ThreadLocalHelper.openDB();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            System.out.println(empDao.getEmpById(1));
            //关闭sqlSession对象
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetEmpByIdAndName() {
        try {
            Reader re = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(re);
            sqlSession = sqlSessionFactory.openSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            System.out.println(empDao.getEmpByIdAndName(1, "关羽"));
            //关闭sqlSession对象
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        try {
            Reader re = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(re);
            //openSession()括号里面不加true，默认事务手动提交
            sqlSession = sqlSessionFactory.openSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            Emp emp = new Emp();
            emp.setName("曹操");
            emp.setAge(50);
            if (empDao.insert(emp) == 1) {
                System.out.println("保存员工成功！");
            } else {
                System.out.println("保存员工失败！请重试！");
            }
            //调用增删改方法后，一定要调用事务提交
            sqlSession.commit();
            testMybatis();
            //关闭sqlSession对象
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
@Test
    public void testUpdate() {
        try {
            Reader re = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(re);
            sqlSession = sqlSessionFactory.openSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            Emp emp = new Emp();
            emp.setName("赵云");
            emp.setAge(100);
            emp.setId(4);
            if (empDao.update(emp) == 1) {
                System.out.println("更新员工成功！");
            } else {
                System.out.println("更新员工失败！请重试！");
            }
            //增删改手动提交事务
            sqlSession.commit();
            //调用查询方法
            testMybatis();
            //关闭sqlSession对象
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDelete(){
        try{
            Reader re = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(re);
            sqlSession = sqlSessionFactory.openSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            if(empDao.delete(4) == 1){
                System.out.println("删除员工成功！");
            } else {
                System.out.println("删除员工失败！请重试！");
            }
            //增删改手动提交事务
            sqlSession.commit();
            //调用查询方法
            testMybatis();
            //关闭sqlSession对象
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
@Test
    public void testCount(){
        try{
//            Reader re = Resources.getResourceAsReader("mybatis.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(re);
//            //openSession(true) true:自动提交事务
//            sqlSession = sqlSessionFactory.openSession(true);

            DBHelper db = new DBHelper();
            sqlSession = db.openDB();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            System.out.println("当前员工总记录数是；"+empDao.count());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //增删改手动提交事务
//            sqlSession.commit();
            //关闭sqlSession对象
            sqlSession.close();
        }
    }
}
