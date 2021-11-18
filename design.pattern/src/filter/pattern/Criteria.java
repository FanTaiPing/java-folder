package filter.pattern;

import java.util.List;

/**
 * 为标准（criteria）创建一个接口
 * 
 * @author y
 *
 */
public interface Criteria {
	public List<Person> meetCriteria(List<Person> persons);
}
