package com.fan.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    /**
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param limit 每页显示的数据条数
     * @return 分页对象
     */
    IPage<Book> findAllBook(Integer page,Integer limit);
    /**
     * 添加图书信息
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 根据id查询图书信息
     * @param id
     * @return
     */
    Book getBookById(int id);

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 根据id删除图书信息
     * @param id
     * @return
     */
    int deleteBook(int id);
}
