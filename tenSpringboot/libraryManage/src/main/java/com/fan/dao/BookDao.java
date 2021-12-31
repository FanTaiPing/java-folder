package com.fan.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.entity.Book;

public interface BookDao extends BaseMapper<Book> {
    /**
     * 查询 : 根据entity状态查询book列表，分页显示
     *
     * @param page 分页查询条件  设置查询的条件
     * @param queryWrapper 拼接sql语句查询条件  封装的是查询的参数
     * @return 分页对象
     */
    IPage<Book> findAllBook(Page<?> page, Wrapper<Book> queryWrapper);

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
