package singleton.mode;

/**
 * 单例模式测试类
 * 
 * @author y
 *
 */
public class SingletonTest {
	public static void main(String[] args) {
		Singleton si = Singleton.getInstance();
		si.setName("张三");
		si.show();
	}
}
