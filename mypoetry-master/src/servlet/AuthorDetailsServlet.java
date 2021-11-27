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
import java.util.List;

/**
 * 作者详情页, 需要传入作者id, 当前页数(默认为0)
 * @author ljsy
 **/
@WebServlet("/author-details")
public class AuthorDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AuthorService authorService = new AuthorServiceImpl();
        PoetryService poetryService = new PoetryServiceImpl();
        // 选中的作者
        int authorId = RequestUtil.getIntParameter(request, "author");
        // 当前页数
        int pageNo = RequestUtil.getIntParameter(request, "page");


        // 有选中作者, 说明是作者详情页
        if (authorId > 0) {
            // 总诗词数
            int count = poetryService.countByAuthor(authorId);

            Page page = new Page(pageNo, 10, count);
            Author author = authorService.findAuthorById(authorId);
            List<Poetry> poetryList = poetryService.findByAuthor(authorId, page);

            request.setAttribute("page",page);
            request.setAttribute("author", author);
            request.setAttribute("count",count);
            request.setAttribute("poetryList",poetryList);

            request.getRequestDispatcher("/pages/authordetails.jsp").forward(request,response);
        } else {
            request.setAttribute("msg","莫愁前路无知己, 天下谁人不识君");
            request.getRequestDispatcher("/pages/404.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
