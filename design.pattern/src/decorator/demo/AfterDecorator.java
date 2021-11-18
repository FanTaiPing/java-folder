package decorator.demo;
/**
 * 装饰之后的类实现接口
 * @author y
 *
 */
public class AfterDecorator implements Sourceable{
	@Override
	public void method() {
		System.out.println("the after decorator method!装饰之后的方法！");
	}
}
