package adapter.demo;
/**
 * 适配器类
 * @author y
 *此类用于类适配器模式
 */
public class Adapter extends Source implements Targetable{	
	//类的适配模式
	@Override
	public void methodTow() {
		System.out.println("这是一个实现接口产生的新方法！");
	}
}
