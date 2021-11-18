package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService{
private UserDao ud =new UserDaoImpl();
	@Override
	public User login(String username, String password) {
	
		return ud.login(username, password);
	}

	@Override
	public User isExistsUser(String username) {
		
		return ud.isExistsUser(username);
	}

	@Override
	public int insertUser(User user) {
	
		return ud.insertUser(user);
	}
	

}
