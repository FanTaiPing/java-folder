package filter.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个实体类(标准男性：CriteriaMale)实现criteria接口
 * 
 * @author y
 *
 */
public class CriteriaMale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> malePersons = new ArrayList<Person>();// 创建一个男人list集合
		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("MALE")) {
				malePersons.add(person);
			}
		}
		return malePersons;
	}
}
