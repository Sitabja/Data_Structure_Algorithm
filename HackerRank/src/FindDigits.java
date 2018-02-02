import java.util.Scanner;


public class FindDigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0 ; i < t ; i++ )
		{   long count = 0l;
			long num = sc.nextLong();
			long temp = num;
			while(temp >  0)
			{ int dig = (int) (temp % 10); 
				 if(dig > 0 && num % dig == 0)
					 count++;
				 temp = temp / 10;
				
			}
			 System.out.println(count);
		}
	}

}
