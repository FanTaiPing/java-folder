package test;

import util.DBHelper;
import util.TestDog;

public class Testdog {
//DBHelper db = new DBHelper();
//
///**
// * 单元测试Junit
// * @throws Exception
// */
//public void testInsert() throws Exception{
//	try {
//		//打开数据库连接
//		db.openDB();
//		//获取st对象
//		db.stmt = db.con.createStatement();
//		StringBuffer sb = new StringBuffer();
//	}catch(Exception e) {
//		e.printStackTrace();
//	}finally {
//		//关闭数据库连接
//		db.closeDB();
//	}
//	
//}
	
	
	public static void main(String[] args) throws Exception{
		TestDog td = new TestDog();
		td.testInsert();
	}
}
