package com.fan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.entity.Book;
import com.fan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookDaoController {
    @Autowired
    private BookService bookService;

    @GetMapping("findAllBook")
    public String findAllBook(Model model, Integer currentPage, Integer limit, HttpSession session) {
        try {
            //后台首页刷新数据时，先判断是否已经登录，如果没有登录则跳转到登录页面登录
            if(session.getAttribute("user") == null){
                return "redirect:/login";
            }
            if (currentPage == null) {
                currentPage = 1;

            }
            if(limit == null){
                limit = 2;
            }
            IPage<Book> bookIPage = bookService.findAllBook(currentPage, limit);
//            System.out.println(bookIPage);
            model.addAttribute("bookIPage", bookIPage);
            //拿到数据的集合
            List<Book> records = bookIPage.getRecords();
            records.forEach(System.out::println);
            model.addAttribute("bookList", records);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "main";
    }

    @GetMapping("addBook")
    public String addBook() {
        return "addBook";
    }

    @PostMapping("addBook")
    public String addBook(Book book) {
        try {
            bookService.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/book/findAllBook";
    }

    @GetMapping("updateBook")
    public String updateBook(Model model, int id) {
        model.addAttribute("book", bookService.getBookById(id));
        return "updateBook";
    }

    @PostMapping("updateBook")
    public String updateBook(Book book) {
        try {
            bookService.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/book/findAllBook";
    }

    @GetMapping("deleteBook")
    public String deleteBook(int id) {
        try {
            bookService.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/book/findAllBook";
    }
}
