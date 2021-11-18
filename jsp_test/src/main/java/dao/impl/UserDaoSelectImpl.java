package dao.impl;

import java.util.List;

import dao.UserDaoSelect;
import entity.User;
import util.DBHelper;

public class UserDaoSelectImpl implements UserDaoSelect{
DBHelper db = new DBHelper();
	@Override
	public List<User> findUserInfo(User user) {
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return null;
	}

}
