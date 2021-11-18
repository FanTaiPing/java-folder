package filter.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个标准女性：CriteriaFemale实体类实现Criteria接口
 * 
 * @author y
 *
 */
public class CriteriaFemale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> femalePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("Female")) {
				femalePersons.add(person);
			}
		}
		return femalePersons;
	}
}
