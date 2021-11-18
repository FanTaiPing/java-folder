package dao.impl;

import dao.UserDao;
import entity.User;
import util.DBHelper;

public class UserDaoImpl implements UserDao{
private DBHelper db = new DBHelper();
	@Override
	public User login(String username, String password) {
		User user = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,username,password from user where username =? and password =?");
			db.ps= db.con.prepareStatement(sb.toString());
			db.ps.setString(1, username);
			db.ps.setString(2, password);
			db.rs= db.ps.executeQuery();
			
			if(db.rs.next()) {
				user = new User();
				user.setId(db.rs.getInt(1));
				user.setUsername(db.rs.getString(2));
				user.setPassword(db.rs.getString(3));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return user;
	}
	@Override
	public User isExistsUser(String username) {
		User user = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,username from `user` where username=?");
			db.ps= db.con.prepareStatement(sb.toString());
			db.ps.setString(1, username);
			db.rs= db.ps.executeQuery();
			if(db.rs.next()) {
			user = new User();
			user.setId(db.rs.getInt(1));
			user.setUsername(db.rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return user;
	}
	@Override
	public User insertUser(String username, String password) {
User user = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("insert into `user`(username,`password`) values(?,?)");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setString(1, username);
			db.ps.setString(2, password);
			db.rs = db.ps.executeQuery();
			if(db.rs.next()) {
				user = new User();
				user.setUsername(db.rs.getString(1));
				user.setPassword(db.rs.getString(2));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return user;
	}
}
