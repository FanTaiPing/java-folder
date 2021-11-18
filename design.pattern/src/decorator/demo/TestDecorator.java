package decorator.demo;
/**
 * 装饰器模式测试类
 * @author y
 *
 */
public class TestDecorator {
public static void main(String[] args) {
	Sourceable source = new Source();
	Sourceable afterDecorator = new AfterDecorator();
	Sourceable dec = new Decorator(source,afterDecorator);
	dec.method();
	}
}
