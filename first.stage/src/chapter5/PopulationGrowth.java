package chapter5;

/**
 * 人口增长
 * 
 * @author HXZY
 *
 */
public class PopulationGrowth {
	public static void main(String[] args) {
		double student = 250000;
		// double growth =250000 * 0.25;
		int year = 2012;
		int i = 0;
		while (student <= 1000000) {

			// student = student +(growth * i);
			student = student * 1.25;
			i++;
			// System.out.println(student);
			System.out.println("自2012年起，第" + i + "年，培训学员人数达到" + student + "人");

		}
		year = year + i;
		System.out.print("到" + year + "年培训学员人数将达到100万人！");

	}

}
