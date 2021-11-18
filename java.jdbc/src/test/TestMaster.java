package test;

/**
 * 测试类
 */
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.Master;
import util.DBHelper;

public class TestMaster {
	// 创建对象db调用DBHelper类
	DBHelper db = new DBHelper();

	/**
	 * 查询
	 */
	@Test
	public void testSelect() throws Exception {
		// 申明一个泛型结合列表
		List<Master> list = new ArrayList<Master>();
		try {
			// 打开连接
			db.openDB();
			// 通过con连接对象获取stmt对象
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,name,password,money from Master");
			// 通过查询方法stmt.executeQuery()返回结果集对象
			db.rs = db.stmt.executeQuery(sb.toString());
			// 申明一个泛型结合列表
//			List<Master> list = new ArrayList<Master>();

			// 循环迭代每一条结果集对象
			while (db.rs.next()) {
				// 创建master对象
				Master master = new Master();
//			根据sql里面的查询字段顺序取值，取出来之后添加到list集合里面
				master.setId(db.rs.getInt(1));
				master.setName(db.rs.getString(2));
				master.setPassword(db.rs.getString(3));
				master.setMoney(db.rs.getDouble(4));
				list.add(master);
			}
			System.out.println("\t\t主人的信息列表是：");
			// forEach()增强型循环打印输出主人的信息
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			db.closeDB();
			list.forEach((master) -> {
				System.out.println(master.getId() + "\t" + master.getName() + "\t" + master.getMoney());
			});
		}

	}

	/**
	 * 增加
	 */
	@Test
	public void testInsert() throws Exception {
		try {
			// 打开连接
			db.openDB();
			// 通过con连接对象获取stmt对象
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			String name = "欧阳兰";
			String password = "abcdef";
			double money = 300;
			sb.append("insert into master(name,password,money)" + "values(");
			sb.append("'" + name + "',");
			sb.append("'" + password + "',");
			sb.append(money);
			sb.append(")");

			// 执行SQL语句返回结果集
			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("插入成功！！");
			} else {
				System.out.println("插入失败！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
			testSelect();
		}
	}

	/**
	 * 删除
	 */
	@Test
	public void testDelete() throws Exception {
		try {
			db.openDB();
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from master where id =5");
			// 执行sql语句并返回结果集,返回的是受影响的行数
			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("删除成功！！");
			} else {
				System.out.println("删除失败！！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
			testSelect();
		}
	}

	/**
	 * 更新
	 */
	@Test
	public void testUpdate() throws Exception {
		try {
			db.openDB();
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("update master set name =" + "'" + "欧阳若" + "'" + "where id =5");
			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("更新成功！！");
			} else {
				System.out.println("更新失败！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
			testSelect();
		}
	}

	@Test
	public void testLogin() throws Exception {
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id from master where name = ? and password = ?");
			db.pstmt = db.con.prepareStatement(sb.toString());
			// 占位符填充（可以防止sql注入）
			db.pstmt.setString(1, "刘春蕾");
			db.pstmt.setString(2, "123456");
			db.rs = db.pstmt.executeQuery();
			Master master = null;
			if (db.rs.next()) {
				master = new Master();
				master.setId(db.rs.getInt(1));
			}
			if (master != null) {
				System.out.println("登录成功+您的用户ID是：" + master.getId());
			} else {
				System.out.println("登陆失败！用户名或密码错误！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
	}
}
