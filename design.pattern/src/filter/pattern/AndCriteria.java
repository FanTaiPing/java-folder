package filter.pattern;

import java.util.List;

/**
 * 创建一个和标准（AddCriteria）实体类实现接口Criteria
 * @author y
 *
 */
public class AndCriteria implements Criteria{
private Criteria criteria;
private Criteria otherCriteria;
public AndCriteria(Criteria criteria,Criteria otherCriteria) {
	 this.criteria = criteria;
	 this.otherCriteria = otherCriteria;
}
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person>firstCriteriaPersons = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}

}
