
public class LIS_Recursive {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,3,7};
		System.out.println(LIS(a,0,1,a.length)+1);
	}

	private static int LIS(int[] a, int l ,int h,int length) {
		if(l == length || h == length)
			return 0;
		else if ( a[l] < a[h])
			return 1 + LIS(a,l+1,h+1,length);
		else
			return max(LIS(a,l+1,h+1,length),LIS(a, l, h+1, length));
	}

	private static int max(int a, int b) {
	
		return a > b ? a : b;
	}

}
