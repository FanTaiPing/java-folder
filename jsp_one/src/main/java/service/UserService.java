package service;

import entity.User;

public interface UserService {
	/**
	 * 根据输入的用户名和密码来查询数据库里的用户名和密码进行登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 根据输入的用户名来查找数据库里面是否存在此用户
	 * 
	 * @param username
	 * @return
	 */
	User isExistsUser(String username);
	/**
	 * 注册用户是当用户提交了注册信息时在用户表中插入一条信息
	 * @param username
	 * @param password
	 * @return
	 */
	User insertUser(String username,String password);
}
