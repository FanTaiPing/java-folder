package util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.Dog;
import util.DBHelper;

public class TestDog {
	DBHelper db = new DBHelper();

	/**
	 * 单元测试Junit
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsert() throws Exception {
		try {
			// 打开数据库连接
			db.openDB();
			// 获取stmt对象
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			String name = "小黄";
			int health = 100;
			int love = 100;
			String strain = "中华田园犬";
			sb.append("insert into dog(name,health,love,strain)" + "values(");
			sb.append("'" + name + "'" + ",");
			sb.append(health + ",");
			sb.append(love + ",");
			sb.append("'" + strain + "'");
			sb.append(")");

			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
			// 查询
//				db.rs = db.stmt.executeQuery("select * from dog");
//				while (db.rs.next()) {
//					//遍历结果集的时候可使用列号（1,2,3...）或列名（name,id,health....）标识列
//					System.out.print(db.rs.getInt("id")+ "\t");
//					System.out.print(db.rs.getString("name") + "\t");
//					System.out.print(db.rs.getInt("health") + "\t\n");
//				}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			db.closeDB();
			testSelect();
		}

	}

//	更新
	@Test
	public void testUpdate() throws Exception {
		try {
			// 打开连接
			db.openDB();
			// 获得stmt对象
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("update dog set love = 100 where id =2");
			int flag = db.stmt.executeUpdate(sb.toString());
			if (flag == 1) {
				System.out.println("更新成功！");
			} else {
				System.out.println("更新失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
			testSelect();
		}
	}

//删除
	@Test
	public void testDelect() throws Exception {
		try {
			// 打开连接
			db.openDB();
			// 获得stmt对象
			db.stmt = db.con.createStatement();

			for (int i = 7; i >= 4; i--) {
				StringBuffer sb = new StringBuffer();
				sb.append("delete from dog where id =");
				sb.append(i);
				int flag = db.stmt.executeUpdate(sb.toString());
				if (flag == 1) {
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
			testSelect();
		}

	}

//查询
	@Test
	public void testSelect() throws Exception {
		try {
			// 打开连接
			db.openDB();
			// 通过con对象获得stmt对象
			db.stmt = db.con.createStatement();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,name,health,love,strain from dog");
			// 查询方法stmt.executeQuery返回结果集对象
			db.rs = db.stmt.executeQuery(sb.toString());
			List<Dog> list = new ArrayList<Dog>();
			// 循环迭代每一条结果集对象
			while (db.rs.next()) {
				Dog dog = new Dog();
				// 根据查询sql里的字段顺序取值，推荐使用
				dog.setId(db.rs.getInt(1));
				// 根据数据库字段名取值，顺序可以乱，不推荐
				dog.setName(db.rs.getString("name"));
				dog.setHealth(db.rs.getInt(3));
				dog.setLove(db.rs.getInt(4));
				dog.setStrain(db.rs.getString(5));
				list.add(dog);
			}
			System.out.println("狗狗信息列表是：");
//		for(Dog dog : list) {
//			System.out.println(dog);	
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
	}
}
