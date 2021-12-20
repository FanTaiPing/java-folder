package com.fan.dao;

import com.fan.entity.Book;

import java.util.List;

public interface BookDao {
    /**
     * 查询所有图书的信息
     * @return
     */
    List<Book> findAllBook();

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
}
