package object6;
/**
 *鼠标实现USB接口
 * @author y
 *
 */
public class UMouse implements UsbInterface {
	public void service() {
		System.out.println("USB接口正在传输鼠标数据");
	}

}
