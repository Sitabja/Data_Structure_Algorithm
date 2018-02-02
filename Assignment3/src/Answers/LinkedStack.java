package Answers;
public class LinkedStack {
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
	Node top;
	public LinkedStack() {
		top = null;
		size = 0;
	}
	public void push(Object o) {
		 Node node = new Node(o);
		 node.next = top;
		 top = node;
		 size++;
	}
	public Object pop() {
		if(isEmpty()){
			throw new EmptyStackException("Stack is Empty");
		}
	    Node n = top;
	    top = top.next;
	    size--;
		return n.element;
	}
	public Object top() {
		return top;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
		// state visualisation
	public String toString() {
		 String output = "";
		 Node node = top;
		 while (node != null) {
			 output = node.element.toString() + " " + output;
			 node = node.next;
		 }
		 return "" + size + "\t" + output;
	}

}
