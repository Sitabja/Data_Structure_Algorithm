import java.util.Arrays;


public class MyClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int T[] = {1,2,4,5,8,9};
		int P[] = {4,5,8};
		
		int n = BruteForceStringMatch(T, T.length, P, P.length);
		
		System.out.println(n);

	}
	
	private static int BruteForceStringMatch(int T[], int n, int P[], int m)
	{
		for(int i = 0; i <= n-m ; i++ )
		{
			int j = 0;
			while(j < m && P[j] == T[i+j])
				j = j+1 ;
			if( j == m)
				return i;
		}
		
	 return -1;
	}

}
