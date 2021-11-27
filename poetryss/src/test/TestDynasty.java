package test;

import dao.DynastyDao;
import dao.impl.DynastyDaoImpl;
import entity.Dynasty;
import org.junit.Test;

import java.util.List;

/**
 * @author y
 */
public class TestDynasty {
    private DynastyDao dynastyDao = new DynastyDaoImpl();
    @Test
    public void testCountDynasty(){
        int count = dynastyDao.countDynasty();
        System.out.println(count);
    }
    @Test
    public void testDynasty(){
        List<Dynasty> list = dynastyDao.findAllDynasty(0,20);
        list.forEach(System.out::println);
    }
}
