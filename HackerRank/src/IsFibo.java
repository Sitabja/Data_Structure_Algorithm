import java.util.ArrayList;
import java.util.Scanner;


public class IsFibo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
		String s[] = new String[t];
		ArrayList<Long> al = new ArrayList<Long>();
		al.add(0l);
		al.add(1l);
		al.add(1l);
		long temp = 1l;
		int j = 3;
		while(temp < Math.pow(10, 10))
		{ 
			temp = al.get(j - 1) + al.get(j - 2);
				al.add(temp);
			
			j++;
		}
		
		
		for(int i = 0 ; i < t ; i++)
		{		
			if(al.contains(sc.nextLong()))
				s[i] = "IsFibo" ;
			else
				s[i] = "IsNotFibo" ;
			
		}
		
		for(int i = 0 ; i < t ; i++)
			System.out.println(s[i]);
			
		
	}

}
