package ANSWERS;

public class B6 {
	public static void main(String[] args) {
		int [] a={2,3,4,1,5,6};
		System.out.println(minValueIndex(a,a.length));
	}

	private static int minValueIndex(int[] a, int n) {
		int minValueIndex = a[0];
		for(int k = 1 ; k <= n-1 ; k++){
			if(a[minValueIndex] > a[k]){
				minValueIndex = k;
			}
		}
		return minValueIndex;
	}

}
