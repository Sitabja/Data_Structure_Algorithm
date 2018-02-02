package Answers;
import java.util.Stack;

@SuppressWarnings("serial")
public class ArrayStack<E> extends Stack<E> {
	//holds the stack elements
	private E s[];
	//index of the top
	private int top = -1;
	//capacity of the array
	private final int CAPACITY = 1000;
	//default constructor
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		s = (E[]) new Object[CAPACITY];
	}
	//Parameterized constructor
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		s = (E[])new Object[capacity];	
	}
	public E pop(){
		if(isEmpty()){
			throw new EmptyStackException("Stack is Empty");
		}
		E temp = s[top];
		s[top--] = null;
		return temp;
	}
	@SuppressWarnings("unchecked")
	public E push(Object o){
		if(top == s.length-1){
			throw new FullStackException("Stack is full");
		}
		s[++top] = (E) o;
		return (E) o;
	}
	public int size(){
		// top is the index of the last element in the array, so size = top+1
		return top + 1;
	}
	public boolean isEmpty(){
		return top == -1;
	}
	public E top(){
		return s[top];
	}
	
	@Override
	public String toString(){
		String output = "";
		output += this.top+1+"\t"; 
		for(int i = 0 ; i <= this.top ; i++){
			output += s[i]+" ";
		}
		return output;
	}
	
}
