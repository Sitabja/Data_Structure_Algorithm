
public class Min_Insertion_DP {
	public static void main(String[] args) {
		String s = "abcbda";
		int result = minInsertion(s,s.length());
		System.out.println(result);
	}

	private static int minInsertion(String s, int n) {
		int[][] tab = new int [n][n];
		for(int gap = 1 ; gap < n ; gap++ )
			for (int i = 0 , j = gap ; j < n ; j++,i++){
				 if (s.charAt(i) == s.charAt(j))
				 {
					 tab[i][j] = tab[i+1][j-1];
				 }
				 else
					 tab[i][j] = min (tab[i+1][j],tab[i][j-1])+1;
				 System.out.println(s);
				 System.out.println(s.charAt(i)+"  "+s.charAt(j));
				 for(int k = 0 ; k < n ;k++){
						for(int m = 0 ; m < n ; m++)
							System.out.print(tab[k][m]+" ");
						System.out.println();
					}
				 System.out.println();
			}
		
		return tab[0][n-1];
		
	}

	private static int min(int a, int b) {
		
		return a > b ? b:a;
	}

}
