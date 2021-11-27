package servlet;

import entity.Page;
import entity.Poetry;
import entity.Type;
import service.AuthorService;
import service.DynastyService;
import service.PoetryService;
import service.TypeService;
import service.impl.AuthorServiceImpl;
import service.impl.PoetryServiceImpl;
import service.impl.TypeServiceImpl;
import util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 展示搜索框查询的结果
 *
 * @author ljsy
 **/
@WebServlet("/type")
public class TypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PoetryService poetryService = new PoetryServiceImpl();
        TypeService typeService = new TypeServiceImpl();

        int typeId = RequestUtil.getIntParameter(request, "type");
        int typePageNo = RequestUtil.getIntParameter(request, "tp");
        int poetryPageNo = RequestUtil.getIntParameter(request, "pp");


        Page typePage = new Page(typePageNo, 100, typeService.countAll());

        // 类型列表
        List<Type> typeList = typeService.findAll(typePage);

        // 如果有类型, 显示该类型的诗词
        if (typeId > 0) {

            int size = 10;
            // 计数查询耗时太长, 所以总数依当前页数增加
            poetryPageNo = poetryPageNo == 0 ? 1 : poetryPageNo;
            int itemCount = poetryPageNo * size * 4;
            Page poetryPage = new Page(poetryPageNo, size, itemCount);

            Type type = typeService.findById(typeId);
            List<Poetry> poetryList = poetryService.findByType(typeId, poetryPage);
            // 若返回的数据少于size, 说明数据到末页了
            if (poetryList==null||poetryList.size() < size) {
                poetryPage.setTotalPages(poetryPageNo);
            }
            request.setAttribute("poetryPage",poetryPage);
            request.setAttribute("type", type);
            request.setAttribute("poetryList", poetryList);
        }

        request.setAttribute("typePage",typePage);
        request.setAttribute("typeList", typeList);
        request.getRequestDispatcher("/pages/type.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
