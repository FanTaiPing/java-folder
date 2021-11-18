package util;
/**
 * 方法二的读取配置文件方式
 */
import java.util.ResourceBundle;

import entity.DBUtils;

public class ReadProperties {
	/**
	 * 读取配置文件
	 * 
	 * @return
	 */
	public DBUtils readProperties() {
		DBUtils db = null;
		try {
			// 读取默认src资源文件夹下db.properties配置文件
			ResourceBundle bundle = ResourceBundle.getBundle("db");
			db = new DBUtils();
			db.setDriver(bundle.getString("driver"));
			db.setUrl(bundle.getString("url"));
			db.setUser(bundle.getString("user"));
			db.setPassword(bundle.getString("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return db;
	}
	
	public static void main(String[] args) {
		ReadProperties rp = new ReadProperties();
		DBUtils db = rp.readProperties();
		System.out.println(db);
		
	}
}
