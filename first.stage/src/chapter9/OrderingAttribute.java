package chapter9;
/**
 * 订餐属性
 * @author y
 *
 */
public class OrderingAttribute {
	// 订单的六个属性
		String[] names = new String[4];// 保存订餐人信息
		String[] dishMegs = new String[4];// 保存菜品及份数
		int[] times = new int[4];// 保存送餐日期
		String[] address = new String[4];// 保存送餐地址
		int[] states = new int[4];// 保存订单状态 1.已完成 0.已预订
		double[] sumPrices = new double[4]; // 保存订单的总金额

		String[] dishNames = { "红烧带鱼", "鱼香肉丝", "时令蔬鲜" };// 菜品数组
		double[] prices = new double[] { 38.0, 20.0, 10.0 };// 菜品对应单价数组
		int[] praiseNums = new int[3];// 菜品对应点赞次数数组	
}
