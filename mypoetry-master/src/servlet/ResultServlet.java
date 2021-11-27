package servlet;

import entity.Author;
import entity.Page;
import entity.Poetry;
import service.AuthorService;
import service.PoetryService;
import service.impl.AuthorServiceImpl;
import service.impl.PoetryServiceImpl;
import util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 展示分类提交后的结果
 *
 * @author ljsy
 **/
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthorService authorService = new AuthorServiceImpl();
        PoetryService poetryService = new PoetryServiceImpl();

        String words = request.getParameter("words");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int pageNo = RequestUtil.getIntParameter(request, "page");

        int size = 10;
        // like查询耗时太长, 所以总数依当前页数增加
        pageNo = pageNo == 0 ? 1 : pageNo;
        int itemCount = pageNo * size * 4;
        Page page = new Page(pageNo, size, itemCount);


        if (author != null) {
            // 搜索作者时
            List<Author> authorList = authorService.findAuthorByName(author, page);
            words = author;

            // 若返回的数据少于size, 说明数据到末页了
            if (authorList.size() < size) {
                page.setTotalPages(pageNo);
            }

            request.setAttribute("author", author);
            request.setAttribute("authorList", authorList);
        } else if (title != null) {
            //搜索标题时
            List<Poetry> poetryList = poetryService.findByTitle(title, page);
            words = title;

            // 若返回的数据少于size, 说明数据到末页了
            if (poetryList.size() < size) {
                page.setTotalPages(pageNo);
            }

            request.setAttribute("title", title);
            request.setAttribute("titlePoetryList", poetryList);
        } else if (content != null) {
            // 搜索内容时
            List<Poetry> poetryList = poetryService.findByContent(content, page);
            words = content;

            // 若返回的数据少于size, 说明数据到末页了
            if (poetryList.size() < size) {
                page.setTotalPages(pageNo);
            }

            request.setAttribute("content", content);
            request.setAttribute("contentPoetryList", poetryList);
        } else {
            // 搜索全局时
            page = new Page(1, 3, 3);

            List<Author> authorList = authorService.findAuthorByName(words, page);
            List<Poetry> titlePoetryList = poetryService.findByTitle(words, page);
            List<Poetry> conPoetryList = poetryService.findByContent(words, page);

            request.setAttribute("authorList", authorList);
            request.setAttribute("titlePoetryList", titlePoetryList);
            request.setAttribute("contentPoetryList", conPoetryList);
        }

        request.setAttribute("words", words);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
