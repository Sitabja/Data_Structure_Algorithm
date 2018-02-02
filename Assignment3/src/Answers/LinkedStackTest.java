package Answers;

public class LinkedStackTest {
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		LinkedStack s = new LinkedStack();
		System.out.println(s);
		s.push("A");
		System.out.println(s);
		s.push("B");
		System.out.println(s);
		s.push("C");
		System.out.println(s);
	}
}
