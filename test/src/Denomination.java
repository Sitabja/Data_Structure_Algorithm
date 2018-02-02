
public class Denomination {
	
	public static void main(String[] args) {
	 // no of ways
		int n = 25 ;
		int i;
		int [] x = {3,5,10};
		int [] a = new int[n+1] ;
		a[0] = 1;
		int min = 17 ;
		
		for(int j = 0; j <x.length ; j++)
		 {	for(i = x[j] ; i <= n ; i++ )
				a[i] += a[i - x[j]];
		 
			for( int k=0 ; k<= n ; k++)
				System.out.print(a[k]+" ");
			System.out.println();
		 }
		
		/*for(int j = 0; j <x.length ; j++)	 	
			while( n >= x[j])
			{
				min = minimum(min,1 + a[n - x[j]]) ;
				n -= x[j] ;
		
			}
	  
		System.out.println("minimum ways "+min);
		*/
		
	
			
		System.out.println("total no of ways "+a[n]);
		
		
	}

	/*private static int minimum(int min, int i) {
		return  min >= i ? i : min ;
		
	}*/

}
