
public class CountSort {
	
	public static void main(String[] args) {
		int[] ar = {1,4,1,2,7,5,2};
		int[] count = new int[ar.length+1];
		int[] output = new int[ar.length+1];
		
		for(int i = 0 ; i < ar.length ; i++){
			count[ar[i]]++;
		}
		System.out.println("count array :");
		System.out.print(count[0]+" ");
		for(int i = 1 ; i < count.length ; i++ ){
			count[i] += count[i-1];
			System.out.print(count[i]+" ");
		}
		
		for(int i = 0 ; i < ar.length ; i++) {
			
			output[count[ar[i]]] = ar[i];
			--count[ar[i]];
		}
		System.out.println();
	System.out.println("sorted array :");	
	for(int i = 0 ; i < output.length ; i++) {
		System.out.print(output[i]+" ");
	}
	
			
		
	}

}
