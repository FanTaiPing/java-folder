package util;

import java.util.ResourceBundle;

import entity.DBUtils;

/**
 * 配置文件读取类
 * 
 * @author y
 *
 */
public class ReadProperties {
	public DBUtils readProperties() {
		DBUtils db = null;
		try {
//读取默认src资源文件夹下的db.properties配置文件
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
}
