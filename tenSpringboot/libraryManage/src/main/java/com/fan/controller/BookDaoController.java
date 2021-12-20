package com.fan.controller;

import com.fan.entity.Book;
import com.fan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookDaoController {
    @Autowired
    private BookService bookService;

    @GetMapping("findAllBook")
    public String findAllBook(Model model) {
        try {
            List<Book> bookList = bookService.findAllBook();
            model.addAttribute("bookList", bookList);
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
    public String updateBook(Model model,int id) {
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
}
