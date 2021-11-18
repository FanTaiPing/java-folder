package object_6;

/**
 * 智能手机类
 * 
 * @author 86151
 *
 */
public class AptitudeHandset extends Handset implements Network, TheakePictures, PlayWiring {

	@Override
	public void takePicture() {
		System.out.println("咔嚓.....拍照成功");
	}

	@Override
	public void networkCoon() {
		System.out.println("已经启动移动网络............");
	}

	@Override
	public String play(String content) {
		return content;
	}

	/**
	 * 方法重写
	 */
	@Override
	public void print() {
		System.out.println("这是一款型号为" + getType() + "的" + getBrand() + "手机：");
	}

	/**
	 * 重写发送文字图片信息方法
	 */
	public void sendInfo() {
		System.out.println("发送带图片与文字的信息..........");
	}

	/**
	 * 重写视频通话方法
	 */
	public void call() {
		System.out.println("开始视频通话..........");
	}

	@Override
	public void info() {

	}

	@Override
	public void voice() {

	}

}
