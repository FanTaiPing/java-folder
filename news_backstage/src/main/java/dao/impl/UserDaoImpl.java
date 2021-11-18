package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import dao.UserDao;
import entity.DBUtils;
import entity.PageBean;
import entity.User;
import utils.DBHelper;
import utils.JDBCUtil;
import utils.JDBCUtils;
import utils.ReadProperties;

public class UserDaoImpl implements UserDao {
	private DBHelper db = new DBHelper();

	@Override
	public List<User> findAll(int start, int rows) {
		List<User> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,`username`,`password` from `user` limit ?,? ");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, start);
			db.ps.setInt(2, rows);
			db.rs = db.ps.executeQuery();
			list = new ArrayList<User>();
			while (db.rs.next()) {
				User user = new User();
				user.setId(db.rs.getInt(1));
				user.setUsername(db.rs.getString(2));
				user.setPassword(db.rs.getString(3));
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return list;
	}

	@Override
	public int userInsert(User user) {
		int flag = 0;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("insert into user(username,password) values(?,?)");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setString(1, user.getUsername());
			db.ps.setString(2, user.getPassword());
			flag = db.ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return flag;
	}

	@Override
	public User login(String username, String password) {
		User user = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select username,`password` from `user` where username = ? and password = ? ");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setString(1, username);
			db.ps.setString(2, password);
			db.rs = db.ps.executeQuery();
			if (db.rs.next()) {
				user = new User();
				user.setUsername(db.rs.getString(1));
				user.setPassword(db.rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return user;
	}

	@Override
	public int deleteUser(int id) {
		int flag = 0;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from `user` where id = ?");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, id);
			flag = db.ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return flag;
	}

	@Override
	public User userById(int id) {
		User user = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,username,`password` from `user` where id = ?");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, id);
			db.rs = db.ps.executeQuery();
			if (db.rs.next()) {
				user = new User();
				user.setId(db.rs.getInt(1));
				user.setUsername(db.rs.getString(2));
				user.setPassword(db.rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return user;
	}

	@Override
	public int updateUserById(User user) {
		int flag = 0;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("update `user` set `username` = ?,`password` = ? where id = ? ");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setString(1, user.getUsername());
			db.ps.setString(2, user.getPassword());
			db.ps.setInt(3, user.getId());
			flag = db.ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return flag;
	}

	/*
	 * @Override public int findTotalCount(Map<String, String[]> condition) { int
	 * flag = 0; try{ db.openDB(); StringBuilder sb = new StringBuilder();
	 * //1.定义模板初始化sql sb.append("select count(1) from `user` where 1 = 1 "); //遍历map
	 * Set<String> keySet = condition.keySet(); //定义参数的集合 List<Object> params = new
	 * ArrayList<Object>(16);
	 * 
	 * for(String key : keySet) { //排除分页的条件参数 if("currentPage".equals(key) ||
	 * "rows".equals(key)){ //结束当前循环，继续下一次循环 continue; }
	 * 
	 * //获取value 获取到的是一个数组value[], //在查询页面的每一个输入框中永远不可能同时出现多个值，因此只需要获取第一个值 String
	 * value = condition.get(key)[0]; //判断value是否有值 if(value != null &&
	 * !"".equals(value)) { //有值 注意空格，否则拼接之后会全部粘到一起 sb.append(" and " + key +
	 * " like ? "); // 加?条件的值 params.add("'%" +value +"%'"); } }
	 * System.out.println(sb.toString()); System.out.println(params);
	 * db.ps=db.con.prepareStatement(params.toArray().toString());
	 * db.ps.setString(1, params.toString()); db.rs = db.ps.executeQuery();
	 * if(db.rs.next()) { flag = db.rs.getInt(1); } }catch(Exception e) {
	 * e.printStackTrace(); }finally { db.closeDB(); } return flag;
	 * 
	 * }
	 */
	
	/*
	 * // 1.定义模板初始化sql String sql = "select count(1) from `user` where 1 = 1 ";
	 * JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
	 * StringBuilder sb = new StringBuilder(sql);
	 * 
	 * // 遍历map Set<String> keySet = condition.keySet(); // 定义参数的集合 List<Object>
	 * params = new ArrayList<Object>();
	 * 
	 * for (String key : keySet) { // 排除分页的条件参数 if ("currentPage".equals(key) ||
	 * "rows".equals(key)) { // 结束当前循环，继续下一次循环 continue; }
	 * 
	 * // 获取value 获取到的是一个数组value[], // 在查询页面的每一个输入框中永远不可能同时出现多个值，因此只需要获取第一个值 String
	 * value = condition.get(key)[0]; // 判断value是否有值 if (value != null &&
	 * !"".equals(value)) { // 有值 注意空格，否则拼接之后会全部粘到一起 sb.append(" and " + key +
	 * " like ? "); // 加?条件的值 params.add("'%" + value + "%'"); }
	 * System.out.println(sb.toString()); System.out.println(params);
	 * 
	 * } return template.queryForObject(sql, Integer.class, params.toArray());
	 */

	@Override
	public int findTotalCount() {
		int flag = 0;
		try{
			db.openDB();
			StringBuilder sb = new StringBuilder();
			//1.定义模板初始化sql
			sb.append("select count(1) from `user`");
			db.ps=db.con.prepareStatement(sb.toString());
			db.rs = db.ps.executeQuery();
			if(db.rs.next()) {
				flag = db.rs.getInt(1);					
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return flag;
	}
}
