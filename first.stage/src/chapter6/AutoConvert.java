package chapter6;
/**
 * 自动转换
 */
public class AutoConvert {
	public static void main(String[] arges) {
		double firstAvg = 81.29;// 第一次平均分
		double secondAvg; // 第二次平均分
		int rise = 2;// rise 增加
		// 小数和整数相加，在java里面会将小数取整向下之后再相加；自动将double 转换为int
		secondAvg = firstAvg + rise;
		System.out.println("第二次平均分是：" + secondAvg);
		//强制转换(大转小：强制转换；小转大：自动转换(大小指的是数值的大小))
		int thirdAvg = (int) secondAvg - rise;
		System.out.print("第三次平均分是：" + thirdAvg);
		//int a= (int)10.2;
	}
}
