package factorycomputer;
/**
 * 华硕电脑子类
 * @author y
 *
 */
public class Asus extends Computer{
/**
 * 重写父类抽象方法
 */
	@Override
	public void start() {
		System.out.println("启动华硕电脑！");
		
	}

}
