package Answers;
public class LinkedQueue<E> implements Queue<E> {
	public class Node {
		Object element;
		Node next;
		public Node(Object element) {
			this.element = element;
		}
		public String toString() {
			return element.toString();
		}
	}
	int size;
	Node front;
	Node rear;
	
	public LinkedQueue(){
		size = 0;
		front = null;
		rear = null;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E front() throws EmptyQueueException {
		if (isEmpty()){
		      throw new EmptyQueueException("Queue is empty.");
		}	
		return (E) front;
	}

	@Override
	public void enqueue(E element) {
		Node n = new Node(element);
		if(rear == null){
			rear = n;
			front = n;
		}
		rear.next = n;
		rear = n;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()){
		      throw new EmptyQueueException("Queue is empty.");
		}
		Node n = front;
		front = front.next;
		size --;
		return (E) n;
	}
	@Override
	public String toString(){
		String output = "";
		Node temp = front;
		while (!temp.equals(rear)){
			output = output + temp.element+" ";
			temp = temp.next;
		}
		return output;
	}
}
