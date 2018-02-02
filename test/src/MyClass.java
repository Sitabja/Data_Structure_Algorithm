import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyClass {
	private static int[] a = { 3, 5, 10 };
	private static List<Integer> l = new ArrayList<Integer>() ;
	private static List<String> l1 = new ArrayList<String>() ;
	
	public static void main(String[] args) {
		test(0 , 20);
		System.out.println(l1.size());
		System.out.println(l1);
	}
	private static void test(int m,int n)
	{ 
		if( m == n )
		{   
			String s = " ";
			List<Integer> l2 = new ArrayList<Integer>();
			l2.addAll(l);
			Collections.sort(l2) ;
		    for(int i = 0; i < l2.size() ; i++)
		    	s+=l2.get(i)+" " ;
		    if(!l1.contains(s))
		    	l1.add(s);
		    return;
		}
		for(int i = 0 ; i < a.length ; i++)
		{
			int next = m + a[i] ;
			if( next > n)
				break;
			else
			{  	l.add(a[i]);
				test( next , n);
				l.remove(l.size() - 1);
			}
		}
		
		
	}
}
