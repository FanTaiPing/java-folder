package object7;

/**
 * 自定义年龄不正常类
 * 
 * @author y
 *
 */
public class AbnormalAgeException extends Exception {
	/**
	 * 创建一个带参构造方法，调用父类Exception带参构造方法
	 * 
	 * @param msg
	 */
	public AbnormalAgeException(String msg) {
		super(msg);
	}
}
