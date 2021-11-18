package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao {
/**
 * 分页查询每页的记录
 * @param start 开始的页码
 * @param rows  每页显示的记录数
 * @param condition 
 * @return
 */
	List<User> findAll(int start, int rows);

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
 * 查询总记录数
 * @param condition 
 * @return
 * @throws SQLException 
 */
int findTotalCount();
}
