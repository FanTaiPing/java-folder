package util;
/**
 * 连接和关闭数据库类
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import entity.DBUtils;

/**
 * 数据库工具类
 * 
 * @author y
 *
 */
public class DBHelper {
	/**
	 * 连接对象
	 */
	public Connection con;
	/**
	 * 申明或陈述对象（执行sql语句并返回结果）
	 */
	public Statement stmt;
	/**
	 * 解决sql注入问题和不需要拼接字符串（用占位符的形式）
	 */
	public PreparedStatement ps;

	/**
	 * 结果集对象（用来返回查询语句的结果，通过循环迭代）
	 */

	public ResultSet rs;

	public ReadProperties rp;


	/**
	 * 打开数据库连接
	 */
	public void openDB() {
		try {
//			方法一：
//			//1.通过反射加载数据库驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			//通过设备管理器获得连接
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pet?serverTimezone=UTC&&useSSL=false","root","root");

//		方法二：
			rp = new ReadProperties();
			DBUtils db = rp.readProperties();
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());			
			
//			方法三：
			//当调用的属性和方法是公共的静态方法时，可以使用类名.方法名（）或者类名.属性，不需要创建对象
//			Class.forName(BaseDao.driver);
//			con = DriverManager.getConnection(BaseDao.url,BaseDao.user,BaseDao.password);
			//使用创建对象的方式调用也可以
//			BaseDao bd = new BaseDao();
//			Class.forName(bd.driver);
//			con = DriverManager.getConnection(bd.url,bd.user,bd.password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @throws Exception
	 */
	public void closeDB(){
		try {
			// 关闭结果集对象
			if (rs != null) {
				rs.close();
			}
			// 关闭Statement对象
			if (stmt != null) {
				stmt.close();
			}
			// 关闭preparStatement对象
			if (ps != null) {
				ps.close();
			}
			// 关闭Connection对象
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
