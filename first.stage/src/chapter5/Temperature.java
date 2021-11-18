package chapter5;
/**
 * 华氏温度与摄氏温度对照表
 * @author HXZY
 *
 */
//tenperature  温度
public class Temperature {
	public static void main(String[] args) {
		System.out.print("摄氏温度");
		System.out.println("\t华氏温度");
		int i = 1;
		double cTemperature = 0;
		do {
			//摄氏温度
			double fTemperature = cTemperature*9/5.0 + 32;
			System.out.print(cTemperature);
			System.out.println("\t" + fTemperature);
			cTemperature += 20; 
			//华氏温度
//			System.out.print(cTemperature);
//			System.out.println("\t" + fTemperature);
			i++;
		}while(cTemperature <= 250 && i <= 10);
	}

}
