package str;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestSetDateTime {
	//方法一
//	public static void main(String[] args) {
//		Date date = new Date();
//		try {
//			SimpleDateFormat ymd = new SimpleDateFormat("yyyy年MM月dd日");
//			String now = ymd.format(date);
//			System.out.println("当前系统时间为：" + now);
//			// 创建一个实例对象通过静态方法getInstance获取Calendar对象
//			Calendar dt = Calendar.getInstance();
//			// 将周一(FirstDay)设为每周的第一天(monday)
//			dt.setFirstDayOfWeek(Calendar.MONDAY);
//			// 将年份设为2015年
//			dt.set(Calendar.YEAR, 2015);
//			// 将月份设为4月(java中0-11代表12个月)
//			dt.set(Calendar.MONTH, 3);
//			// 将日数设为第6日
//			dt.set(Calendar.DATE, 6);
//			// 使用Calendar.WEEK_OF_YEAR来求出属于某年的第几周
//			System.out.println("2015年4月6日是第" + dt.get(Calendar.WEEK_OF_YEAR) + "周");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	//方法二
	public static void main(String[] args) throws Exception {
		//创建一个日期对象
		Date nowDay = new Date();
		//SimpleDateFormat构造方法  .parse()方法将字符串格式转为日期格式
		Date historyDay= new SimpleDateFormat("yyyyMMdd").parse("20150406");
		SimpleDateFormat day = new SimpleDateFormat("yyyy年MM月dd日是y年的第w周");
		String now = day.format(nowDay);

		String history = day.format(historyDay);
		System.out.println("当前系统时间为：" + now + "\n" + history);
	}
}
