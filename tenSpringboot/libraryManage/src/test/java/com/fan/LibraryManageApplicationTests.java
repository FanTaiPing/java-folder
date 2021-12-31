package com.fan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.dao.BookDao;
import com.fan.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibraryManageApplicationTests {
    @Autowired
    private BookDao bookDao;

    /**
     * 测试分页查询
     */
    @Test
    public void testFindAllBook() {
        //参数一：当前页 默认值 1  参数二：每页显示记录条数  默认值10
        Page<Book> page = new Page<>(1,2);//查询第一页，查询2条数据
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        //设置查询条件
//        wrapper.like("name","author");

        IPage<Book> iPage = bookDao.findAllBook(page,null);
        System.out.println("数据总条数："+ iPage.getTotal());
        System.out.println("数据总页数"+ iPage.getPages());
        System.out.println("当前页数："+ iPage.getCurrent());

        //拿到数据的集合
        List<Book> records = iPage.getRecords();
        for(Book record : records){
            System.out.println(record);
        }
    }

}
