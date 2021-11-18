package singleton.mode;

/**
 * 单例类
 * 
 * @author y
 *
 */

public class Singleton {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	//一、懒汉式单利模式：先不创建对象，需要用到是再创建
//	①声明静态私有类变量，且立即实例化，保证实例化一次
//	②私有构造，防止外部实例化（通过反射是可以实例化的，不考虑此种情况）
//	③提供public的getInstance（）方法供外部获取单例实例
//	好处：线程安全；获取实例速度快 
//	缺点：类加载即初始化实例，内存浪费
//	/**
//	 * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
//	 */
//	private static Singleton singleton;// 懒汉式单利模式：先不创建对象，需要用到是再创建
//
//	/**
//	 * 私有构造方法，防止被实例化
//	 */
//	private Singleton() {
//
//	}
//	/**
//	 * 静态工程方法，创建实例（对象）
//	 * 
//	 * @return
//	 */
//	public static Singleton getInstance() {
//		if (singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}

//二、饿汉式单利模式：直接先创建对象，只要类加载完成就创建对象
//	优点：在获取实例的方法中，进行实例的初始化，节省系统资源
//	缺点：①如果获取实例时，初始化工作较多，加载速度会变慢，影响系统系能
//	private static Singleton singleton = new Singleton();// 饿汉式单利模式：直接先创建对象，只要类加载完成就创建对象
//
//	private Singleton() {
//	System.out.println("这是一个单例模式");
//	}
//	public static Singleton getInstance() {
//		return singleton;
//	}

//三、线程安全的懒汉式单利模式（双重检验锁模式）
	
	private static Singleton singleton;

	private Singleton() { // 私有无参构造方法
		System.out.println("这是一个单例模式");
	}

	public static synchronized Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
//	优点：线程安全，进行双重检查，保证只在实例未初始化前进行同步，效率高 
//	缺点：还是实例非空判断，耗费一定资源
	
	/**
	 * 显示方法
	 */
	public void show() {
		System.out.println("名字叫：" + name);
	}
}
