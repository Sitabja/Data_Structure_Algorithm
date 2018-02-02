package ANSWERS;

public class C10 {
	public static void main(String[] args) {
		int arraySize = 1000000;
		for (int j=1; j <=10 ; j++ ){
			long [] a = new long[arraySize*j];
			double duration = 0.0;
			for(int i = 0 ; i < a.length ; i++){	
				a[i] = i*10000000;
				
			}
			for(int k = 1 ; k <=5 ; k++){
				 long start = System.currentTimeMillis();
				 linearSearch(a,a.length,a[a.length-1]); //passing the last element as search query
				 long end = System.currentTimeMillis();
				 duration += end -start; 
			}
			System.out.println(a.length+" "+duration / 5);
		}
		
	}

	private static int linearSearch(long[] a, int n, long q) {
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
