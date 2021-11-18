package str;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateTime {
	public static void main(String[] args) {

		// 创建当前日期对象
		Date dt = new Date();
		try {
			// 日期对象转字符串
			// yyyy 年份(year) MM月份(day) dd日(day) hh小时(hour) mm分钟(minutes) ss秒(seconds)
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = sdf.format(dt);
			System.out.println("当前系统日期时间是：" + str);

			// 字符串对象转日期对象
			dt = sdf.parse(str);
			System.out.println(dt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
