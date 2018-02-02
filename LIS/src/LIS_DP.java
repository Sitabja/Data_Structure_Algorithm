
public class LIS_DP {
	public static void main(String[] args) {
		int a[] = {1,-1,0,3,-1,4,6,0,2};
		System.out.println(LIS(a,a.length));
	}

	private static int LIS(int[] a,int length) {
		int tab[] = new int[length];
		for(int i = 0 ; i < length ; i++) {
			tab[i] = 1;
		}
		int maxLength = 0;
		for(int i = 1 ; i < length ; i++)
			for(int j = 0 ; j < i ; j++)
			{
				if(a[i] > a[j]) {
					tab[i] = max(tab[i],tab[j]+1);
					if(tab[i] > maxLength)
						maxLength = tab[i];
					
				}
			}
	
		return maxLength;
	}

	private static int max(int a, int b) {
	
		return a > b ? a : b;
	}


}
