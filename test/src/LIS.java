import java.util.ArrayList;
import java.util.List;


public class LIS {
	
	public static void main(String[] args) {
		int[] a = {13,2,1,3,4,3,5,10};
		List<Integer> l = new ArrayList<Integer>();
		
		for( int i = 0 ; i < a.length - 1 ; i++)
		{ 
			List<Integer> l1 = new ArrayList<Integer>() ;
			l1.add(a[i]);
			int m = a[i];
			
			for( int j = i+1 ; j < a.length ; j++ )
			{		
				if(a[j] >= m)
				{  
					l1.add(a[j]);
					
					m = a[j];
				}
				
				/*else
					break;*/
				
				
			}
			
			if(l1.size() > l.size())
				l = l1 ;
		}
		
		System.out.println(l);
		
	}

}
