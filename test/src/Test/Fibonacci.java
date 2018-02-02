package Test;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibbo(n));
	}

	private static int fiboDP(int n) {
		int []pre = new int[n+1];
		
		for (int i = 0; i <= n ;i++){
			if(i <= 1){
				pre[i] = i;
			} else {
				pre[i] = pre[i-1]+pre[i-2];
			}
		}
		
		return pre[n];
	}

	private static int fiboRecur(int n) {
		if(n<=1){
			return n;
		} 
		return fiboRecur(n-1)+fiboRecur(n-2);
	}

	private static int fibbo(int n) {
		int a = 0, b = 1, c=0;
		if(n<=1){
			return n;
		}
	   System.out.println(a);
	   System.out.println(b);
		for (int i=2 ; i <= n ; i++){
			c = a+b;
			System.out.println(c);
			a = b;
			b = c;
			
		}
		return c;
		
	}
}
