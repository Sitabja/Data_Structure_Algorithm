import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Collection {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		
		for(int i = 0 ; i < t ; i++ )
		{
			long n = sc.nextLong();
			long sum = 0l;
			boolean flag = false;
			boolean flag1 = false;
			long min = 0l;
			for(int j = 0 ; j < n ; j++)
			{
				long s = sc.nextLong();
				sum += s;
				
				
				
			if(!flag)	
			{	
				if(s < min)
					min = s;
				
				if( sum < 0 )
				{	
					sum -= min;
					sum +=(-min);
					flag = true;
					
						
				}
			}	
			 if ( sum < 0 && flag && !flag1)
				{ 
				    flag1 = true; 
					System.out.println(j+1);
				}
				
			}
			
			if(sum >= 0 && !flag1)
				System.out.println("She did it!");
		}
	}

}
