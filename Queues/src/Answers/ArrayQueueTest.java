package Answers;

public class ArrayQueueTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		ArrayQueue q = new ArrayQueue();
		System.out.println(q);
		q.enqueue(new Integer(15));
		q.enqueue(new Integer(35));
		q.enqueue(new Integer(15));
		q.enqueue(new Integer(25));
		q.enqueue(new Integer(45));
		q.enqueue(new Integer(65));
		q.enqueue(new Integer(75));
		q.enqueue(new Integer(85));
		System.out.println(q);
		q.dequeue();
		System.out.println(q);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q);
		
	}
}
