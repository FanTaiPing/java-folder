package service;

import java.sql.SQLException;
import java.util.Map;

import entity.PageBean;
import entity.User;

public interface UserService {
/**
 * 分页查询
 * 分页条件查询
 * @param currentPage  当前页码
 * @param rows   每页显示的记录数
 * @param condition 
 * @return
 * @throws SQLException 
 */
	PageBean<User> findAll(String currentPage, String rows);
/**
 * 用户登录
 * @param username
 * @param password
 * @return
 */
User login(String username,String password);
/**
 * 用户注册
 * @return
 */
int userInsert(User user);
/**
 * 根据id删除用户表中的用户信息
 * @param id
 * @return
 */
int deleteUser(int id);
/**
 * 根据id查询用户的信息
 * @param id
 * @return
 */
User userById(int id);
/**
 * 根据id修改用户的信息
 * @param id
 * @return
 */
int updateUserById(User user);
/**
 * 根据id批量删除用户
 * @param ids
 */
void delSelectedUser(String[] ids);
}
