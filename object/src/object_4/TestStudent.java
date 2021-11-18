package object_4;

public class TestStudent {
	public static void main(String[] args) {
		Student stuOne = new Student();
		stuOne.setId("9527");
		stuOne.setName("华安");

		Student stuTwo = new Student();
		stuTwo.setId("9527");
		stuTwo.setName("华安");

		System.out.println(stuOne.equals(stuTwo));
		System.out.println(stuOne);
		System.out.println(stuTwo);
	}
}
