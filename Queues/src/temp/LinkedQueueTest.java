package Answers;

public class LinkedQueueTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	
		
		LinkedDeque llq = new LinkedDeque();
		llq.addFirst(new Integer(15));
		System.out.println(llq);
		llq.removeLast();
		System.out.println(llq);
		llq.addFirst(new Integer(20));
		System.out.println(llq);
	}
}
