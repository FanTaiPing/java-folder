package service;
import entity.PageBean;
import entity.User;

import java.util.List;

/**
 * @author y
 */
public interface UserService{
    /**
     * 注册用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * @param username 用户名
     * @param password 密码
     * @return 返回 user 对象
     */
    User login(String username, String password);

    /**
     * 查询用户表里面的所有信息
     * @param currentPage 当前页
     * @param rows  每页显示的记录条数
     * @return
     */
    PageBean<User> findAllUser(int currentPage, int rows);

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     * 根据id查询用户信息  用于修改用户信息
     * @param id
     * @return
     */
    User FindUserByIdServlet(int id);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteUserById(int id);
    /**
     * 根据id批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);
}
