package test;

import util.DBHelper;

public class TestConnection {
	public static void main(String[] args) {

//创建对象
		DBHelper db = new DBHelper();
		try {
			db.openDB();
			System.out.println("数据库连接成功！！");
			db.closeDB();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！！");
		}
	}
}