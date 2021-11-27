package dao;

import entity.User;

import java.util.List;

/**
 * @author y
 */
public interface UserDao {
    /**
     * 查询用户表里的所有信息
     * @param start 开始的记录索引
     * @param rows  每页显示的记录条数
     * @return 返回一页的数据列表
     */
    List<User> findAllUser(int start, int rows);
    /**
     * 注册用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户输入的用户名判断用户是否存在
     *
     * @param username
     * @return
     */
    User isExitsUser(String username);

    /**
     * @param username 用户名
     * @param password 密码
     * @return 返回 user 对象
     */
    User login(String username, String password);

    /**
     * 查询user总记录条数
     * @return
     */
    int countUser();
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
}
