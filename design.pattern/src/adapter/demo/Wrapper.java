package adapter.demo;
/**
 * 包装器
 * @author y
 * 
 * abstract(实现接口适配器模式)
 */
public abstract class Wrapper implements Targetable{
//	//对象的适配器模式  当为此模式时，类为一个公共类即可
//	private Source source;
//	public Wrapper(Source source) {
//		super();
//		this.source = source;
//	}
//	@Override
//	public void methodTow() {
//		System.out.println("这是一个实现接口得到的方法！");
//	}
//	@Override
//	public void methodOne() {
//		//通过对象来调用源类中的方法
//		source.methodOne();
//	}

	
	
	//接口的适配器模式   当为此模式的时候需把类改为抽象类，让适配器类去继承此抽象类中的所有方法，在每个类中需要用时再调用就可以了
	@Override
	public void methodOne() {
		
	}

	@Override
	public void methodTow() {
		
	}
}
