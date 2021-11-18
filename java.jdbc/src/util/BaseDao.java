package util;
/**
 * 方法三的读取配置文件类
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseDao {
	public static String driver;
	public static String url;
	public static String user;
	public static String password;
	static {
		init();
	}

	public static void init() {
		Properties params = new Properties();
		String configFile = "db.properties";
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
	}
}
