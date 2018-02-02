package Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LCM_PrimeFactor {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt() ;
	for(int j = 0 ; j < t ; j++){
		int x  = sc.nextInt();
		int y = sc.nextInt();
		Set<Integer> s = new HashSet<Integer>();
		int lcm = x*y / gcd(x,y);

		while(lcm % 2 == 0){
			lcm = lcm /2;
			s.add(2);
		}
		

		for(int i = 3 ;i < Math.sqrt(lcm) ; i+=2){
			while (lcm % i == 0)
			{
				s.add(i);
				lcm  = lcm/i;
			}	
		}
		if(lcm > 2){
			s.add(lcm);
		}
		
		System.out.println(isPrime(s.size()));
	}
	
	
	}

	private static String isPrime(int size) {
		if(size == 1 ){
			return "No";
		}
		
		for(int i = 2; i < Math.sqrt(size); i++){
			if(size % i == 0){
				return "No";
			}
		}
		return "Yes";
	}

	private static int  gcd(int x, int y) {
		 int r=0;
	     int  a = (x > y) ? x : y; 
	     int  b = (x < y) ? x : y; 
	 
	        r = b;
	        while(a % b != 0) {
	            r = a % b;
	            a = b;
	            b = r;
	        }
	        return r;
	}
}
