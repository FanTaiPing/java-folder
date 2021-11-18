package test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.Epet;
import util.DBHelperEpet;

/**
 * 测试员工类
 * 
 * @author y
 *
 */
public class TestEpet {
	// 创建db对象
	DBHelperEpet db = new DBHelperEpet();

	/**
	 * 查询所有员工数据并控制台输出
	 */
	@Test
	public void testSelectAll() throws Exception {
		try {
			// 打开数据库连接
			db.openDBEpet();
			// 通过con对象获得stmt对象
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,name,birthday,salary from epet");
			// 执行sql语句返回结果集
			db.rs = db.stmt.executeQuery(sb.toString());
			// 申明一个泛型集合列表来存储结果
			List<Epet> list = new ArrayList<Epet>();
			// 循环迭代每一条结果集对象
			while (db.rs.next()) {
				// 创建epet对象
				Epet epet = new Epet();
				// 根据查询语句中的查询字段顺序取值，并将其添加到list集合里面
				epet.setId(db.rs.getInt(1));
				epet.setName(db.rs.getString(2));
				epet.setBirthday(db.rs.getString(3));
				epet.setSalary(db.rs.getDouble(4));
				list.add(epet);
			}
			System.out.println("员工信息列表是：");
			// 通过forEach输出list集合
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			db.closeDBEpet();
		}
	}

	/**
	 * 根据ID查询单条员工数据
	 */
	@Test
	public void testSelectSingle() throws Exception {
		try {
			// 打开连接
			db.openDBEpet();
			// 通过con对象获得stmt对象
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,name,birthday,salary from epet where id = 1");
			// 执行sql语句返回结果集
			db.rs = db.stmt.executeQuery(sb.toString());

			List<Epet> list = new ArrayList<Epet>();
			// 循环迭代每一条结果解对象
			while (db.rs.next()) {
				// 创建epet对象
				Epet epet = new Epet();
				epet.setId(db.rs.getInt(1));
				epet.setName(db.rs.getString(2));
				epet.setBirthday(db.rs.getString(3));
				epet.setSalary(db.rs.getDouble(4));
				list.add(epet);
			}
			System.out.println("员工信息列表为：");
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			db.closeDBEpet();
		}
	}

	/**
	 * 添加一个员工数据
	 */
	@Test
	public void testInsert() throws Exception {
		try {
			db.openDBEpet();
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
//			String name = "小明";
//			String birthday = "2021-09-11";
//			double salary = 2500;
			sb.append("insert into epet(name,birthday,salary)" + "values('小明','2021-09-11','2500')");
			// 执行sql语句结果集
			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("插入成功！！！");
			} else {
				System.out.println("插入失败！！！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDBEpet();
			testSelectAll();
		}
	}

	/**
	 * 根据ID删除单条员工数据
	 */
	@Test
	public void testDelete() throws Exception {
		try {
			db.openDBEpet();
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from epet where id = 6");
			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("删除成功！！！");
			} else {
				System.out.println("删除失败！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDBEpet();
			testSelectAll();
		}
	}

	/**
	 * 更新一条员工数据
	 */
	@Test
	public void testUpdate() throws Exception {
		try {
			db.openDBEpet();
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("update epet set name = '李大大' where id = 2");

			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("更新成功！！！");
			} else {
				System.out.println("更新失败！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDBEpet();
			testSelectAll();
		}
	}
}
