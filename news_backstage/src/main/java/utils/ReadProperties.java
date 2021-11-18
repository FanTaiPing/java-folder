package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import entity.DBUtils;

public class ReadProperties {
public DBUtils readProperties() {
	DBUtils db = null;
	try {
		ResourceBundle bundle =ResourceBundle.getBundle("db");
		db = new DBUtils();
		db.setDriver(bundle.getString("driver"));
		db.setUrl(bundle.getString("url"));
		db.setUser(bundle.getString("user"));
		db.setPassword(bundle.getString("password"));
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return db;
}
}
