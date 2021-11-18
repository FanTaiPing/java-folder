package datasource.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import utils.JDBCUtils;

public class C3P0Demo1 {
public static void main(String[] args) throws Exception {
	//1.创建数据库连接池对象  括号里什么都不传，使用c3p0.config.xml中的默认配置
	DataSource ds = new ComboPooledDataSource();
	
	//2.获取连接对象
	Connection conn = ds.getConnection();
	
	
	//3.打印  注意：数据库连接jar包一定要导包
	System.out.println(conn);
	}
}
