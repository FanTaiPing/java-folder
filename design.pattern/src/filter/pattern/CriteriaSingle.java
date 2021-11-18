package filter.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个单身女性：CriteriaSingle实体类实现Criteria接口
 * 
 * @author y
 *
 */
public class CriteriaSingle implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> singlePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("Single")) {
				singlePersons.add(person);
			}
		}
		return singlePersons;
	}

}
