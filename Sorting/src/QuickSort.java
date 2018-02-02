
public class QuickSort {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
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
		if( a == null)
			return;
		else 
			quicksort(a,0,a.length-1);
		
	}

	private static void quicksort(int[] a, int start, int end) {
		int pivot = a[(start+end)/2];
		int i = start;
		int j = end;
		while ( i <= j ){
			while(a[i] < pivot) {
				i++;
			}
			while(a[j] > pivot) {
				j--;
			}
			if( i <= j){
				a[i]=(a[i]+a[j])-(a[j]=a[i]);
				i++;
				j--;
			}
		}
		if(i < end) {
			quicksort(a, i, end);
		}
		if(j > start) {
			quicksort(a, start, j);
		}
		
		
	}

}
