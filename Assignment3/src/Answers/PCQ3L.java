package Answers;

public class PCQ3L {
	public static void main(String[] args) {
		LinkedStack s = new LinkedStack();
		System.out.println(s);
		s.push(new String("Ireland"));
		System.out.println(s);
		String c = (String) s.pop();
		s.push(new String("England"));
		System.out.println(s);
		c = (String) s.pop();
		s.push(new String("Wales"));
		System.out.println(s);
		c = (String) s.pop();
		s.push(new String("Scotland"));
		System.out.println(s);
		c = (String) s.pop();
		s.push(new String("France"));
		System.out.println(s);
		s.push(new String("Germany"));
		System.out.println(s);
	}

}
