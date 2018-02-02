package Answers;

public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		ArrayStack s = new ArrayStack();
		System.out.println(s);
		s.push("A");
		System.out.println(s);
		s.push("B");
		System.out.println(s);
		s.push("C");
		System.out.println(s);

	}

}
