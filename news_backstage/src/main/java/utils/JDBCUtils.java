package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import entity.DBUtils;

public class JDBCUtils {
	//private static DBUtils db = new DBUtils();
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	//1.定义成员变量
		private static DataSource pro;
	/**
	 * 文件的读取，只需要读取一次即可拿到只写值，使用静态代码块
	 * 
	 */
	static {
		// 读取资源文件，获取值
		try {
			// 1.创建Properties集合类
			Properties pro = new Properties();

			// 获取src路径下的文件的方式---》ClassLoader 类加载器
			ClassLoader classLoader = JDBCUtils.class.getClassLoader();
			URL res = classLoader.getResource("db.properties");
			String path = res.getPath();

			// 2.加载文件
			pro.load(new FileReader(path));
			
			//3.获取数据，赋值
//			db.setUrl(pro.getProperty("url"));
//			db.setUser(pro.getProperty("user"));
//			db.setPassword(pro.getProperty("password")); 
//			db.setDriver(pro.getProperty("driver"));
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			password= pro.getProperty("password"); 
			driver = pro.getProperty("driver");
			//4.注册驱动
			Class.forName(driver);
					
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * @return 连接对象
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url,user,password);

	}
/**
 * 释放资源
 * @param stmt
 * @param conn
 * @throws SQLException 
 */
	public static void close(PreparedStatement ps, Connection conn) throws SQLException, IOException {	
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 释放资源
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs,PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	public static DataSource getDataSource() {
		
		return pro;
	}
}
