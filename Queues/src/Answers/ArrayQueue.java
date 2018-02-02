package Answers;


public class ArrayQueue<E> implements Queue<E> {
	//holds the queue elements
	private E q[];
	//value of the front
	private int front = 0;
	//value of the rear
	private int rear = 0;
	//array Size
	private static final int CAPACITY = 1000;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(){
		q = (E[]) new Object[CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity){
		q = (E[]) new Object[capacity];
	}
	
	@Override
	public int size() {
		return rear - front;
	}
	
	@Override
	public boolean isEmpty() {
		return rear == front;
	}

	@Override
	public E front() throws EmptyQueueException {
		if(isEmpty()){
			throw new EmptyQueueException("Queue is Empty");
		}
		return q[front];
	}

	@Override
	public void enqueue(E element) throws FullQueueException {
		if(this.size()==this.CAPACITY){
			throw new FullQueueException("Queue is Empty");
		}
		q[rear++] = element; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()){
			throw new EmptyQueueException("Queue is Empty");
		}
		Object element =  q[front++];
		return (E) element;
	}
	@Override
	public String toString(){
		String output = "";
		output += this.size()+"\t"; 
		for ( int i = front ; i < rear ; i++){
			output += q[i]+" ";
		}
		return output;
	}

}
