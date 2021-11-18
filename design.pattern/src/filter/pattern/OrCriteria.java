package filter.pattern;

import java.util.List;

/**
 * 创建一个或者标准(OrCriteria)类实现Criteria接口
 * @author y
 *
 */
public class OrCriteria implements Criteria{
private Criteria criteria;
private Criteria otherCriteria;

public OrCriteria(Criteria criteria,Criteria otherCriteria) {
	this.criteria = criteria;
	this.otherCriteria = otherCriteria;
}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
List<Person>firstCriteriaItems = criteria.meetCriteria(persons);
List<Person>otherCriteriaItems = otherCriteria.meetCriteria(persons);
for(Person person : otherCriteriaItems) {
	if(!firstCriteriaItems.contains(person)) {
		firstCriteriaItems.add(person);
	}
}
return firstCriteriaItems;
	}

}
