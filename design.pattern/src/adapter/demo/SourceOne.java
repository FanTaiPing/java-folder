package adapter.demo;
/**
 * 此类用于接口适配器模式
 * @author y
 *
 */
public class SourceOne extends Wrapper{
	//接口的适配器模式
	public void methodOne() {
		System.out.println("这是实现原接口中的第一个方法");
	}
}
