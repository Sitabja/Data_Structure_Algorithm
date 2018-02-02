
public class MergeSort {
	public static void main(String[] args) {
		
		int[] a = {5,4,2,3,1,6,7,8,9};
		System.out.println("unsorted array : ");
		for(int i = 0 ; i < a.length ; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("sorted array : ");
		sort(a);
		for(int i = 0 ; i < a.length ; i++){
			System.out.print(a[i]+" ");
		}
		
	}

	private static void sort(int[] a) {
		int n = a.length;
		if(n <= 1)
			return;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for(int i = 0 ; i < mid ; i++) {
			left[i] = a[i];
		}
		
		for(int j = 0 ; j < right.length ; j++ ){
			right[j] = a[j+mid];
		}
		sort(left);
		sort(right);
		merge(left,right,a);
		
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int nl = left.length;
		int nr = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < nl && j < nr) {
			if(left[i] < right[j]){
				a[k] = left[i++];
			} else {
				a[k] = right[j++];
			}
			k++;
		}
		while(i < nl){
			a[k] = left[i++];
			k++;
		}
		while(j < nr) {
			a[k] = right[j++];
			k++;
		}		
	}
	
	

}
