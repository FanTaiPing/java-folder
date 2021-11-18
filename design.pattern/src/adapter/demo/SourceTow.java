package adapter.demo;
/**
 * 
 * @author y
 *此类用于接口适配器模式
 */
public class SourceTow extends Wrapper{
	//接口的适配器模式
	public void methodTow() {
		System.out.println("这是实现原接口中的第二个方法");
	}
} 