package object_2;
/**
 * 创建学生业务类
 * @author HXZY
 *
 */
public class StudentBiz {
	/**
	 * 学生对象数组
	 */
	StudentScore[] stus = new StudentScore[2];

	/**
	 * 添加学生
	 * 
	 * @param stu 学生对象作为参数
	 */
	public void addStu(StudentScore stu) {
		for (int i = 0; i < stus.length; i++) {
			if (stus[i] == null) {
				stus[i] = stu;
				break;

			}
		}
	}

}
