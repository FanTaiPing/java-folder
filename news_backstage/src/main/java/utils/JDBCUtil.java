package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/**
 * Druid连接池的工具类
 * @author y
 *
 */
public class JDBCUtil {
//1.定义成员变量
	private static DataSource ds;
	
	static {
		try {
		//1.加载配置文件
		Properties pro = new Properties();
		pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
		//2.获取DataSource
		ds = DruidDataSourceFactory.createDataSource(pro);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	} 
	
	public static void close(PreparedStatement ps,Connection conn) {
//		if (ps != null) {
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		close(null,ps,conn);
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();//归还连接
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * 获取连接池方法
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}
}
