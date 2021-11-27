package service.impl;

import dao.AuthorDao;
import dao.impl.AuthorDaoImpl;
import entity.Author;
import entity.PageBean;
import entity.User;
import service.AuthorService;

import java.util.List;

/**
 * @author y
 */
public class AuthorServiceImpl implements AuthorService {
    private AuthorDao authorDao = new AuthorDaoImpl();
    private PageBean<Author> pb = null;
    @Override
    public PageBean<Author> findAllAuthor(int currentPage, int rows) {
        //创建一个空的PageBean对象
        pb = new PageBean<Author>();

        //判断当前页码是否小于1，如果小于1的话，将当前页码置为1
        if (currentPage < 1) {
            currentPage = 1;
        }

        //将参数设置到pb对象里面
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //获取总记录数
        int totalCount = authorDao.countAuthor();
        //将总记录数设置到pb对象里
        pb.setTotalCount(totalCount);

        //计算总页码
        int totalPage = totalCount % rows == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        //将总页码数设置到pb对象里面
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        pb.setTotalPage(totalPage);

        //将每页的数据设置到pb对象里
        //计算开始的页码
        //先计算初始的页码索引 start = (当前页码-1) * rows(每页显示的数据条数)
        int start = (currentPage - 1) * rows;
        List<Author> list = authorDao.findAllAuthor(start,rows);
        //将list列表添加到pb对象里
        pb.setList(list);

        return pb;
    }

    @Override
    public Author findIdByName(String name) {
        return authorDao.findIdByName(name);
    }

    @Override
    public int deleteAuthorById(int id) {
        return authorDao.deleteAuthorById(id);
    }
}
