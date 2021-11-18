package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.DBUtils;

/**
 * 数据库连接类
 * 
 * @author y
 *
 */
public class DBHelper {
	/**
	 * 创建连接对象
	 */
	public Connection con;
	/**
	 * 申明或陈述对象（执行sql语句并返回结果集）
	 */
	public PreparedStatement ps;
	/**
	 * 结果集对象（返回查询语句的结果，通过迭代循环输出）
	 */
	public ResultSet rs;

	/**
	 * 打开数据库连接
	 */
	public void openDB() {
		ReadProperties rp = null;
		
		try {
			//创建配置文件读取对象
			rp = new ReadProperties();
			//通过get和set方法获取读取配置文件的方法
			DBUtils db = rp.readProperties();
			// 1.通过设备管理器加载驱动
			Class.forName(db.getDriver());
			// 2.获得连接对象
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 关闭数据库连接
	 */
	public void closeDB() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通用的增删改方法
	 * @param sql 增删改sql语句
	 * @param args 参数
	 * @return flag 受影响的行数
	 * @throws Exception
	 */
	public int insertDelUpdate(String sql,Object[] args) throws Exception {
		int flag = 0;
		try {
			openDB();
			ps = con.prepareStatement(sql);
			if(args !=null) {
				for(int i=0;i<args.length;i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			flag = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return flag;
	}
}
