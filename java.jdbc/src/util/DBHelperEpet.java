package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBHelperEpet {
	// 创建连接对象
	public Connection con;
	// 申明或陈述对象（用来执行sql语句）
	public Statement stmt;
	// 结果集对象（用来返回结果集）
	public ResultSet rs;

	/**
	 * 打开数据库连接
	 */
	public void openDBEpet() {
		
			//使用资源绑定器绑定属性配置文件   方法一：
			ResourceBundle bundle = ResourceBundle.getBundle("db");
			String driver = bundle.getString("driver");
			String url = bundle.getString("url");
			String user = bundle.getString("user");
			String password = bundle.getString("password");	
			try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			
			
//			// 1.通过反射加载数据库驱动   方法二：
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// 2.通过设备管理器获得连接
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false", "root",
//					"root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库连接
	 */
	public void closeDBEpet() {
		try {
			if (rs != null) {
				//关闭结果集对象rs
				rs.close();
			}
			if (stmt != null) {
				//关闭申明或陈述对象stmt
				stmt.close();
			}
			if (con != null) {
				//关闭连接对象con
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
