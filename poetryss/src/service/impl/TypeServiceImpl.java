package service.impl;

import dao.TypeDao;
import dao.impl.TypeDaoImpl;
import entity.PageBean;
import entity.Type;
import service.TypeService;

import java.util.List;

/**
 * @author y
 */
public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao = new TypeDaoImpl();
    private PageBean<Type> pb = null;
    @Override
    public PageBean<Type> findAllType(int currentPage, int rows) {
        //创建一个空的PageBean对象
        pb = new PageBean<Type>();

        //判断当前页码是否小于1，如果小于1的话，将当前页码置为1
        if (currentPage < 1) {
            currentPage = 1;
        }

        //将参数设置到pb对象里面
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //获取总记录数
        int totalCount = typeDao.countType();
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
        List<Type> list = typeDao.findAllType(start,rows);
        //将list列表添加到pb对象里
        pb.setList(list);
        return pb;
    }

    @Override
    public Type findIdByName(String type_name) {
        return typeDao.findIdByName(type_name);
    }
}
