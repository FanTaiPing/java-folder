package decorator.demo;
/**
 * 被装饰的源类实现接口
 * @author y
 *
 */
public class Source implements Sourceable{

	@Override
	public void method() {
		System.out.println("the original method!原来的方法");		
	}
}
