

public class BogoSort {
	
	public static void main(String[] args) {
		int arr[]={2,3,0,4,1,7,9,6,10,8,5};
		int brr[] = new int[arr.length];
		for(int i=0;i<brr.length;i++)
			brr[i]=arr[i];
		
		
		
		long a=System.currentTimeMillis();
		//System.out.println("Completed in "+bogoSort(arr)+" shuffles");
		long b = System.currentTimeMillis();
		System.out.println("Time to complete in millisec: "+(b-a));
		System.out.println("Completed in "+effectiveBogoSort(brr)+" shuffles");
		long c = System.currentTimeMillis();
		System.out.println("Time to complete in millisec: "+(c-b));
	}
	//---------------------------------------------------------------------------
	public static long bogoSort(int a[])
	{
		int arr[]=new int[a.length];
		long count = 0;
		while(!checkSort(a))
		{	
			count ++;
			for(int i=a.length-1;i>=0;i--)
			{
				int index=(int) (Math.random()*(i+1));
				
				 arr[a.length-i-1]=a[index];
				  	for(int j=index+1;j<=i;j++)
				  		{
				  			a[j-1]=a[j];
				  		}
				

			}
			
			for(int i=0;i<a.length;i++)
			{
				a[i]=arr[i];
			}
			
			
			/*System.out.print("Suffle "+count+" :: ");
			for(int i=0;i<a.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
			
			System.out.println();*/
			
		}
		return count;
	}

	private static boolean checkSort(int[] a) {
		
		for(int i=0;i<a.length-1;i++)
			if(a[i]>a[i+1])
				return false;
		
		return true;
	}
	
//----------------------------------------------------------------	
	public static long effectiveBogoSort(int a[])
	{
		int arr[]=new int[a.length];
		long count = 0;
		int unsorted;
		int brr[];
		while((unsorted=checkSort1(a))!=0)
		{	
			
			count ++;
			brr = new int[unsorted];
			for(int i=0,j=0;i<a.length;i++)
				if(a[i]!=i)
					brr[j++]=a[i];
			
			
			
			for(int i=brr.length-1;i>=0;i--)
			{
				int index=(int) (Math.random()*(i+1));
				
				 arr[brr.length-i-1]=brr[index];
				  	for(int j=index+1;j<=i;j++)
				  		{
				  			brr[j-1]=brr[j];
				  		}
			}
		
			for(int i=0,j=0;i<a.length;i++)
				if(a[i]!=i)
					a[i]=arr[j++];
		
			/*System.out.print("Suffle "+count+" :: ");
			for(int i=0;i<a.length;i++)
			{
				System.out.print(a[i]+" ");
			}
			
			System.out.println();*/
		
		}
		return count;
	}

	private static int  checkSort1(int[] a) {
		int unsorted = 0;
		for(int i=0;i<a.length;i++)
			if(a[i]!=i)
				unsorted ++;
		
		return unsorted;
	}
}
