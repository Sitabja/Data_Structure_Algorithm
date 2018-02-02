import java.util.ArrayList;
import java.util.Scanner;


public class Making_A_Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0 ; i < t ; i++)
		{
			String s = sc.next();
			ArrayList<Character> al = new ArrayList<Character>();
			ArrayList<Integer> al1 = new ArrayList<Integer>();
			int count = 0 ;
			for(int j = 0 ; j < s.length() ; j++)
			{ 
				char ch = s.charAt(j);
				if(!al.contains(ch))
					{ 
					 	al.add(ch);
					 	al1.add(1);
					 	
					}
				else
					al1.set(al.indexOf(ch), al1.get(al.indexOf(ch)) + 1);
			}
			
			for(int k = 0 ; k < al1.size() ; k++)
			{
				if(al1.get(k) % 2 != 0)
				{
					count++;
				}
			}
			
			if( count > 0)
			System.out.println(count - 1);
			else
				System.out.println(count);
			
		}
		
	}

}
