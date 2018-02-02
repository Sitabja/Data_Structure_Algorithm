
public class Quick {
	private static int[] a={3,5,7,-4,9,1,2,10};
	public static void main(String[] args) {
		quickSort(0,a.length-1);
		for(int i=0 ; i<a.length ;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	private static void quickSort(int low, int high) {
		int i = low;
		int j = high;
		
		int pivot = a[low + (high-low)/2 ];
		//System.out.println(pivot);
	
		while( i <= j)
		{ 
			while(a[i] < pivot)
				i++;
			while(a[j] > pivot)
				j--;
			if(i <= j)
				{  //System.out.println("here "+a[i]+" "+a[j]+" "+pivot);
					a[i] = (a[i]+a[j])-(a[j] = a[i]); //single line swap a[i] and a[j]
					i++ ;
					j-- ;
				}
			
		
			
		}
		
		if( low < j)
			quickSort(low, j);
		if(i < high)
			quickSort(i, high);
		
	}

}
