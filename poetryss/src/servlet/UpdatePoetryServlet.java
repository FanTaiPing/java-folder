package servlet;

import entity.Author;
import entity.Poetry;
import entity.Type;
import service.AuthorService;
import service.PoetryService;
import service.TypeService;
import service.impl.AuthorServiceImpl;
import service.impl.PoetryServiceImpl;
import service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author y
 */
@WebServlet("/UpdatePoetryServlet")
public class UpdatePoetryServlet extends HttpServlet {
    private PoetryService poetryService = new PoetryServiceImpl();
    private AuthorService authorService = new AuthorServiceImpl();
    private TypeService typeService = new TypeServiceImpl();
    private Poetry poetry = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        poetry = new Poetry();
        String id = request.getParameter("id");
        poetry.setId(Integer.parseInt(id));
        String title = request.getParameter("title");
        poetry.setTitle(title);
        String author = request.getParameter("author");
        //将查到的作者对象（包含了作者id的对象）添加到poetry对象里
        Author authorId = authorService.findIdByName(author);
        poetry.setAuthor(authorId);

        String content = request.getParameter("content");
        poetry.setContent(content);
        String translate = request.getParameter("translate");
        poetry.setTranslate(translate);
        String translate_res = request.getParameter("translate_res");
        poetry.setTranslate_res(translate_res);
        String notes = request.getParameter("notes");
        poetry.setNotes(notes);
        String appreciation = request.getParameter("appreciation");
        poetry.setAppreciation(appreciation);
        String appreciation_res = request.getParameter("appreciation_res");
        poetry.setAppreciation_res(appreciation_res);
        String type = request.getParameter("type");
        Type typeId = typeService.findIdByName(type);
        poetry.setType(typeId);

        int flag = poetryService.updatePoetry(poetry);
        if(flag ==1){
            response.sendRedirect(request.getContextPath()+"/PoetryServlet");
        }else{
            response.sendRedirect(request.getContextPath()+"/FindPoetryByIdServlet");
        }
    }
}