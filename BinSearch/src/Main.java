import java.util.Arrays;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  int[] a = {1 ,12, 13, 4, 8, 10, 4, 8, 9, 5};
	  int n = 20 ;
	  Arrays.sort(a);
	  for(int j=0;j<a.length;j++)
	      System.out.print(a[j]+" ");
	 System.out.println();
	  int i = Bin(a,n);
	  
	  if(i!=-1)
		System.out.println("found in "+i+" search");
	  else
		  System.out.println("not found");
	
	}

	private static int Bin(int[] a, int n) {
		int start = 0;
		int end = a.length-1;
		int mid = (start+end)/2;
		
		int i=0;
		
		while(a[mid] !=  n && start !=end)
		{
			
			i++;
			if(n >a[mid])
				start = mid+1;
			if (n < a[mid])
				end = mid-1;
			
			mid = (start+end)/2;
			
			 System.out.println("start: "+start+" mid: "+mid+" end: "+end );
		}
		if(start == end && a[mid] != n)
			return -1;
		return i;
		
	}

}
