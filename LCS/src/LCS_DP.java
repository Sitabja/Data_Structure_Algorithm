
public class LCS_DP {
	public static void main(String[] args) {
		String s1 = "asdftr";
		String s2 = "absdkjl";
		int result = LCS(s1,s2,s1.length(),s2.length());
		System.out.println(result);
	}

	private static int LCS(String s1, String s2, int n1, int n2) {
	int [][] tab = new int[n1 + 1][n2 + 1];
		for(int i = 0; i <= n1 ; i++)
			for(int j = 0 ; j <= n2  ;j++) {
				if(i == 0 || j == 0)
					tab[i][j] = 0;
				else if( s1.charAt(i - 1) == s2.charAt(j - 1))
				{
					tab[i][j] = 1 + tab[i - 1][j - 1];
					
				}
				else
					tab[i][j] = max(tab[i][j - 1],tab[i - 1][j]);
				
				 for(int k = 0 ; k < n1 ;k++){
						for(int m = 0 ; m < n2 ; m++)
							System.out.print(tab[k][m]+" ");
						System.out.println();
					}
				 System.out.println();

			}
			
		return tab[n1 - 1][n2 - 1];		
	}

	private static int max(int a, int b) {
		
		return a > b ? a : b;
	}
	

}
