package object_6;

/**
 * 普通手机类
 * 
 * @author 86151
 *
 */
public class CommonHandset extends Handset implements PlayWiring {
	@Override
	public String play(String content) {
		return content;
	}

	/**
	 * 方法重写
	 */
	@Override
	public void print() {
		System.out.println("这是一款型号为" + getType() + "的" + getBrand() + "手机");

	}

	/**
	 * 重写发送文字信息
	 */
	public void info() {
		System.out.println("发送文字信息..........");
	}

	/**
	 * 重写语音通话方法
	 */
	public void voice() {
		System.out.println("开始语音通话..........");
	}

	@Override
	public void sendInfo() {

	}

	@Override
	public void call() {

	}
}
