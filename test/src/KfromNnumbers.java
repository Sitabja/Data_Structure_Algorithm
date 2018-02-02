import java.util.Arrays;
import java.util.Scanner;


public class KfromNnumbers {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int minimum = 999999999;
		for(int i = 0 ; i<n ; i++)
			x[i] = sc.nextInt();
		
		
 
		int k = sc.nextInt();
		
		Arrays.sort(x);
		
		
		
		for(int i = 0 ; i <=n - k ; i++)
		{
			int[] y = new int[k] ;
		
			
			for(int j = 0 ; j < k ;j++)
			{ 
				y[j] = x[i+j] ;
				
				
			}
			
			if(y[k-1] - y[0] < minimum)
				minimum = y[k-1] - y[0] ;
			
			
		}
		
		
			 
		System.out.println(minimum );
		
		
	}

}
