
public class MyClass1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int T[] = {1,2,4,5,8,9};
		int P[] = {4,8};
		
		int n = RobinKarp(T, T.length, P, P.length);
		
		System.out.println(n);

	}
  
	private static int RobinKarp(int T[] ,int n, int P[] , int m)
	{
		int value = 0;
		int value1 = 0;
		int t  = 0;
		
		for(int i = 0; i< m ; i++)
		{
			value = value*10;
			value = value + P[i];
			
			value1 = value1*10;
			value1 = value1 + T[i];
			
		}
		
		t = value1;
		
		for( int i = 1; i < n-m ; i++ )
		{
			t = (int) (10 * (t - Math.pow(10, m - 1) * T[i-1]) + T[i + m - 1]);
			 System.out.println(t);
			if( t == value)
				return i;
		}
		
		return -1;
	}
}
