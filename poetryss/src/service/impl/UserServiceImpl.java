package service.impl;


import dao.Dao;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.PageBean;
import entity.User;
import service.UserService;

import java.util.List;

/**
 * @author y
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private PageBean<User> pb = null;

    /**
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public PageBean<User> findAllUser(int currentPage, int rows) {
        //创建一个空的PageBean对象
        pb = new PageBean<User>();

        //判断当前页码是否小于1，如果小于1的话，将当前页码置为1
        if (currentPage < 1) {
            currentPage = 1;
        }

        //将参数设置到pb对象里面
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //获取总记录数
        int totalCount = userDao.countUser();
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
        List<User> list = userDao.findAllUser(start, rows);
        //将list列表添加到pb对象里
        pb.setList(list);

        return pb;
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User FindUserByIdServlet(int id) {
        return userDao.FindUserByIdServlet(id);
    }

    @Override
    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            // 1.遍历数组
            for (String id : ids) {
                // 2.调用dao的方法删除
                userDao.deleteUserById(Integer.parseInt(id));
            }
        }
    }
}
