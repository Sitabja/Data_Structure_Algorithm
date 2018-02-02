import java.util.Scanner;


public class SherlockAndBeast {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String a[] = new String[t];
		
		for( int i = 0 ; i < t ; i++ )
		{
			String s = "";
			long l = sc.nextLong();
			long temp = l;
			long temp1 = temp % 5 ;
			
		
			while(temp1 > 0 )
			{ 
			  if( temp1 % 3 > 0)
				temp1 = temp1  - 5 ;
			  else
				  break;
			
			}
			
			if(temp < 0)
				s+=-1+"";
			else	 
			{ 
				
				
				
				for(long j = 0 ; j <  temp ; j++)
					s+= 5+"";
				
				for(long j = 0 ; j < l - temp ; j++)
					s+= 3+"" ;
			
				
					
			}
			a[i] = s ;
			
				
		}
		
		for(int i = 0 ; i < a.length ; i++)
			System.out.println(a[i]);
	}

}
