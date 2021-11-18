package decorator.demo;
/**
 * 装饰类实现接口
 * @author y
 *
 */
public class Decorator implements Sourceable{
private Sourceable source;
private Sourceable afterDecorator;
public Decorator(Sourceable source,Sourceable afterDecorator) {
	this.source = source;
	this.afterDecorator = afterDecorator;
}
	@Override
	public void method() {
		System.out.println("before decorator!装饰之前");
		source.method();
		System.out.println("after decorator!装饰之后");
		afterDecorator.method();
		
	}
}
