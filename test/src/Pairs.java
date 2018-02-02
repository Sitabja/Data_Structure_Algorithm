import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Pairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long count = 0;
		
		List<Long> l = new ArrayList<Long>();
		
		for(long i = 0 ; i < n ; i++)
		{ 
			l.add(sc.nextLong());
		}
	
		
		for(long i = 0 ; i < l.size() ; i++)
		{
			if(l.indexOf(l.get((int) i) + k) != -1 )
					{
						count++;
					}
		}
		
		System.out.println(count);
	}
}
