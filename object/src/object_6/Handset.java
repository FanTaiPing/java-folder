package object_6;
/**
 * 手机父类
 * @author 86151
 *
 */
public abstract class Handset {
	private String brand;//品牌
	private String type;//型号
	private String content;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}
/**
 * 显示方法
 * @param brand
 * @param type
 */
public abstract void print(); 
/**
 * 发送文字图片信息方法
 */
public abstract void sendInfo();
/**
 * 发送文字信息
 */
public abstract void info();
/**
 * 语音通话方法
 */
public abstract void voice();
/**
 *  重写视频通话方法
 */
public abstract void call();
}
