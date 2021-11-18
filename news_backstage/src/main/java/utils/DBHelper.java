package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import entity.DBUtils;

public class DBHelper {
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	private static ReadProperties rp = null;
	private static DBUtils db = null;


	static {
		rp = new ReadProperties();
		db = rp.readProperties();	
	}
	
	public void openDB() {
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void closeDB() {
		try {
			if(rs !=null) {
				rs.close();
			}
			if(ps !=null) {
				ps.close();
			}
			if(con !=null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
