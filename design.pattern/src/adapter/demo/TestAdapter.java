package adapter.demo;
/**
 * 适配器模式测试类
 * @author y
 *
 */
public class TestAdapter {
public static void main(String[] args) {
//	//类的适配器模式
//	Targetable target = new Adapter();
//	target.methodOne();
//	target.methodTow();
	
	
//	//对象的适配器模式
//	Source source = new Source();
//	Targetable target = new Wrapper(source);
//	target.methodOne();
//	target.methodTow();
	
	//接口的适配器模式
	Targetable target1 = new SourceOne();
	Targetable target2 = new SourceTow();
	
	target1.methodOne();
//	target1.methodTow();
//	target2.methodOne();
	target2.methodTow();
	
	
}
}
