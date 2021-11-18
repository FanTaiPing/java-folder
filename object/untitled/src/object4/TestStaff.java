package object4;

public class TestStaff {
	public static void main (String[] args) {
		Staff staOne = new Staff();
		staOne.setName("银河之力");
		staOne.setEmpleno("10000");
		
		Staff staTow = new Staff();
		staTow.setName("银河之力");
		staTow.setEmpleno("10000");
		
		System.out.println(staOne.equals(staTow));
		System.out.println(staOne);
		System.out.println(staTow);
	}

}
