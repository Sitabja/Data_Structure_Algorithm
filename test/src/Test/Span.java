package Test;

import java.util.Stack;

public class Span {
	public static void main(String[] args) {
		int x[] = {4,3,4,5,2};
		int [] output = spanWithStack(x,x.length);
		for(int i=0;i< output.length ; i++){
			System.out.println(output[i]);
		}
		//spanWithoutStack(x,x.length);
	}
	private static <E> int[]  spanWithStack(int[] x, int n) {
		Stack A= new Stack<E>();
		
		int output []= new int[n];
		//int s=1;
		//output[0] = 1;
		
		for (int i = 0 ; i < n  ;i++){
			while(!A.empty() && x[(Integer) A.peek()] <= x[i]){
				A.pop();
			}
			if(A.isEmpty()){
				output[i] = i+1;;
			} else {
				output[i] = i - (Integer)A.peek();
			}
			A.push(i);	
			
		}
		return output;
		
		
	}

	private static int[]  spanWithoutStack(int[] x, int n) {
		int output []= new int[n];
		int s=1;
		output[0] = 1;
		for (int i = 1 ; i < n  ;i++){	
			if(x[i-1]< x[i]){
				s++;
			} else {
				s = 1;
			}
			output[i] = s;
			
		}
		return output;
		
		
	}

	private static int[] span1(int[] x, int n) {
		int output []= new int[n];
		for (int i = 0 ; i < n  ;i++){
			int s=1;
			while( s < i && x[i-s]<x[i]){
				s++;
			}
			output[i] = s;
			
		}
		return output;
		
	}
}
