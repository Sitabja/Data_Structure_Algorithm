package Test;

import java.util.Scanner;

public class MillyRank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i++){
			long n = sc.nextLong();
			long x = sc.nextLong();
			long y = sc.nextLong();
			
			if( n - x - 1 <= y){
				System.out.println(n -x);
			} else {
				System.out.println(y+1);
			}
			
		}
	}
	
	
}
