
public class Min_Insertion_Recursion {
	public static void main(String[] args) {
		String s = "abcbda";
		int result = minInsertion(s,0,s.length() -1);
		System.out.println(result);
	}

	private static int minInsertion(String s, int i, int j) {
		if(i == j)
			return 0;
		else if ( i > j )
			return -1;
		else if ( i == j-1 )
		{
			return (s.charAt(i)==s.charAt(j))? 0:1;
		}
		
		else {
			if( s.charAt(i) == s.charAt(j))
				return minInsertion(s, i + 1, j - 1);
			else {
				return min(minInsertion(s, i + 1, j),minInsertion(s, i, j - 1))+1;
			}
		}
		
	}

	private static int min(int a, int b) {
		
		return a > b ? b:a;
	}

}
