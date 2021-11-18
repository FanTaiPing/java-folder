package object2;

/**
 * 创建一个客户信息业务类
 * 
 * @author HXZY
 *
 */
public class CustomBiz {
	/**
	 * 客户信息对象数组
	 */
	UpdateCustomInfo[] custInfo = new UpdateCustomInfo[10];

	/**
	 * 添加客户信息
	 * 
	 * @param cust 客户信息对象作为参数
	 */
	public void addCustom(UpdateCustomInfo cust) {
		for (int i = 0; i < custInfo.length; i++) {
			if (custInfo[i] == null) {
				custInfo[i] = cust;
				break;
			}

		}
	}

}