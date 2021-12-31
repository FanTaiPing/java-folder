package com.fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.dao.BookDao;
import com.fan.entity.Book;
import com.fan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    @Override
    public IPage<Book> findAllBook(Integer currentPage,Integer limit) {
//        Book book = new Book();
//        book.setName("");
//        book.setAuthor("");
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        if(currentPage<=0){
            currentPage = 1;
        }
        Page<Book> bookPage = new Page<>(currentPage,limit);
        return bookDao.findAllBook(bookPage,null);
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bookDao.deleteBook(id);
    }
}
