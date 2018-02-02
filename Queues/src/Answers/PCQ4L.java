package Answers;

public class PCQ4L {
	public static void main(String[] args) {
		LinkedDeque<String> ld = new LinkedDeque<String>();
		System.out.println(ld);
		ld.addFirst("Ireland");
		System.out.println(ld);
		ld.removeLast();
		System.out.println(ld);
		ld.addLast("England");
		System.out.println(ld);
		ld.removeFirst();
		System.out.println(ld);
		ld.addLast("Wales");
		System.out.println(ld);
		ld.addFirst("Scorland");
		System.out.println(ld);
		ld.addLast("France");
		System.out.println(ld);
		ld.removeFirst();
		System.out.println(ld);
		ld.removeLast();
		System.out.println(ld);
		ld.addLast("Germany");
		
		System.out.println(ld);
	}

}
