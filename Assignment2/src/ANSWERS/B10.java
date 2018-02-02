package ANSWERS;

public class B10 {
	public static void main(String[] args) {
		int [] a = {2,3,4,1,5,6};
		System.out.println(linearSearch(a,a.length,1));
		
	}

	private static int linearSearch(int[] a, int n, int q) {
		int index = 0;
		while( index < n && a[index] != q){
			index = index + 1;
		}
		if (index == n){
			return -1;
		} else {
			return index;
		}
	}
}
