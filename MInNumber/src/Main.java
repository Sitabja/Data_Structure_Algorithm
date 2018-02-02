
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 11;
		System.out.println(solve(n));
		

	}

	private static int solve(int n) {
		if(n == 1)
			return 0;
		else
		{
			int x = 0;
			x = 1 + solve(n-1);
			
			if(n%2 == 0)
				{ 
					
				    x = 1 + min(x,solve(n/2));
				}
			
			if(n%3 == 0)
				{	   
				 	  
				       x = 1 + min(x,solve(n/3));
				}
			
			return x;
		}
		
	}

	private static int min(int x, int solve) {
	 if(x <= solve)
		return x;
	 else
		 return solve;
	}

}
