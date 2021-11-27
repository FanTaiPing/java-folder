package service.impl;

import dao.PoetryDao;
import dao.impl.PoetryDaoImpl;
import entity.PageBean;
import entity.Poetry;
import service.PoetryService;

import java.util.List;

/**
 * @author y
 */
public class PoetryServiceImpl implements PoetryService {
    private PoetryDao poetryDao = new PoetryDaoImpl();
    private PageBean<Poetry> pb = null;

    @Override
    public PageBean<Poetry> findAllPoetry(int currentPage, int rows) {
        //创建一个空的PageBean对象
        pb = new PageBean<Poetry>();

        //判断当前页码是否小于1，如果小于1的话，将当前页码置为1
        if (currentPage < 1) {
            currentPage = 1;
        }

        //将参数设置到pb对象里面
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //获取总记录数
        int totalCount = poetryDao.countPoetry();
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
        List<Poetry> list = poetryDao.findAllPoetry(start, rows);
        //将list列表添加到pb对象里
        pb.setList(list);
        return pb;
    }

    @Override
    public Poetry findPoetryById(int id) {
        return poetryDao.findPoetryById(id);
    }

    @Override
    public int deletePoetryById(int id) {
        return poetryDao.deletePoetryById(id);
    }

    @Override
    public int addPoetry(Poetry poetry) {
        return poetryDao.addPoetry(poetry);
    }

    @Override
    public int updatePoetry(Poetry poetry) {
        return poetryDao.updatePoetry(poetry);
    }

    @Override
    public void delSelectedPoetry(String[] ids) {
        if (ids != null && ids.length > 0) {
            // 1.遍历数组
            for (String id : ids) {
                // 2.调用dao的方法删除
                poetryDao.deletePoetryById(Integer.parseInt(id));
            }
        }
    }
}
