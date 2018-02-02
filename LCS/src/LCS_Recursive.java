
public class LCS_Recursive {
	public static void main(String[] args) {
		String s1 = "aggtab";
		String s2 = "gxtxayb";
		int result = LCS(s1,s2,s1.length(),s2.length());
		System.out.println(result);
	}

	private static int LCS(String s1, String s2, int n1, int n2) {

		if(n1 == 0 || n2 == 0)
			return 0 ;
		if(s1.charAt( n1 - 1 ) == s2.charAt(n2 - 1))
				return 1+(LCS(s1,s2,n1-1,n2-1));
		else
				return max(LCS(s1,s2,n1,n2-1),LCS(s1,s2,n1-1,n2));		
		
	}

	private static int max(int a, int b) {
		
		return a > b ? a : b;
	}

}
