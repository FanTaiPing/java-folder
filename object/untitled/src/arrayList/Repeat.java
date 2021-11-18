package arrayList;

import java.util.HashSet;
import java.util.Set;

public class Repeat {
	public static void main(String[] args) {
		int[] nums = { 5, 5, 4, 84, 2, 55, 7, 1, 7, 5, 5, 3, 5, 7, 7 };
		// 申明一个set集合
		Set set = new HashSet();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (Object ob : set) {
			System.out.print(ob + "\t");
		}
	}
}