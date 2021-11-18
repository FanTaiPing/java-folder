package filter.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类 使用不同的标准（criteria）和他们的结合来过滤Person对象的列表
 * 
 * @author y
 *
 */
public class FilerPatternTest {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("张三", "Male", "Single"));
		persons.add(new Person("李四", "Male", "Married"));
		persons.add(new Person("王五", "Female", "Married"));
		persons.add(new Person("杨六", "Female", "Single"));
		persons.add(new Person("沈七", "Male", "Single"));
		persons.add(new Person("宋八", "Male", "Single"));

		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		Criteria singleMale = new AndCriteria(single, male);
		Criteria singleOrFemale = new OrCriteria(single, female);

		System.out.println("Males:");
		printPersons(male.meetCriteria(persons));
		System.out.println("\nFemales:");
		printPersons(female.meetCriteria(persons));
		System.out.println("\nSingle Males:");
		printPersons(singleMale.meetCriteria(persons));
		System.out.println("\nSingle Or Females:");
		printPersons(singleOrFemale.meetCriteria(persons));
	}

	public static void printPersons(List<Person> persons) {
		for (Person person : persons) {
			System.out.println("Person:[Name:]" + person.getName() + ",Gender:" + person.getGender()
					+ ",Marital status:" + person.getMaritalStatus() + "]");
		}
	}
}
