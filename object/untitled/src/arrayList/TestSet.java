package arrayList;

/**
 * Set方法去重
 */
import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		String s1 = new String("java");
		String s2 = s1;
		String s3 = new String("JAVA");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.print(set.size());
	}
}
