package entity;

/**
 * 封装连接对象的属性
 * 
 * @author y
 *
 */
public class DBUtils {
	private String driver;
	private String url;
	private String user;
	private String password;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBUtils [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password + "]";
	}
}
