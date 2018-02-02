
public class LargestSumSubsequence {
	public static void main(String[] args) {
		int[] a = {4,-3,-2,6,7,-1,10};
		System.out.println(test(a,a.length)) ;
	}

	private static int test(int a[], int n)
	{
		int m = 0;
		int m1 = 0;
		
		
		for(int i = 0 ; i < n ; i++ )
		{
			m += a[i];
			
			if( m < 0)
				m = 0;
			
			if( m > m1)
				m1 = m;
		}
		
		
		return m1;

	}
}
