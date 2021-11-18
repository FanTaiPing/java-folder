package service.impl;

import java.util.List;
import java.util.Map;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.PageBean;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public PageBean<User> findAll(String _currentPage, String _rows) {
		int currentPage = Integer.parseInt(_currentPage);
		int rows = Integer.parseInt(_rows);

		if (currentPage <= 1) {
			currentPage = 1;
		}
		// 1.创建空的PageBean对象
		PageBean<User> pb = new PageBean<User>();
		// 2.设置参数
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);

		// 3.调用dao查询总记录数totalCount
		int totalCount = userDao.findTotalCount();
		pb.setTotalCount(totalCount);

		// 4.调用doa查询list集合
		// 计算开始的记录索引
		int start = (currentPage - 1) * rows;
		List<User> list = userDao.findAll(start, rows);
		// 将list集合添加到pb对象里面
		pb.setList(list);

		// 5.计算总页码
		int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		pb.setTotalPage(totalPage);

		return pb;
	}

	@Override
	public int userInsert(User user) {

		return userDao.userInsert(user);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.login(username, password);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public User userById(int id) {
		// TODO Auto-generated method stub
		return userDao.userById(id);
	}

	@Override
	public int updateUserById(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserById(user);
	}

	@Override
	public void delSelectedUser(String[] ids) {
		if (ids != null && ids.length > 0) {
			// 1.遍历数组
			for (String id : ids) {
				// 2.调用dao的方法删除
				userDao.deleteUser(Integer.parseInt(id));
			}
		}
	}
}
