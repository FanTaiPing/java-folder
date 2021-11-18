package object6;

/**
 * 打印机类
 * 
 * @author y
 *
 */
public class Printer implements InkBox,Paper{

	@Override
	public String A4Paper() {
		// TODO Auto-generated method stub
		return "A4纸";
	}

	@Override
	public String B5Paper() {
		// TODO Auto-generated method stub
		return "B5纸";
	}

	@Override
	public String blackAndWhie() {
		// TODO Auto-generated method stub
		return "黑白墨盒";
	}

	@Override
	public String colour() {
		// TODO Auto-generated method stub
		return "彩色墨盒";
	}

}
