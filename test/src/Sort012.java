
public class Sort012 {
	public static void main(String[] args) {
		int a[] = {1,0,2,2,0,1,2,0};
		int count0 = 0;
		int count1 = 0;
		int count = a.length-1;
		
		for(int i = 0 ; i < a.length; i ++){
			while(a[i] == 2 && count >= count1 && count >= count0)
			{ 	
				a = swap(a,i,count);
				count -- ;
			}
			if(a[i] == 0) {
				if(a[count0] == 1)
					{ a[count1] = 1;
					count1++;}
				if(count0 == count1)
					count1++;
				
				a[count0] = 0;
				count0++;
					
			}
			else if (a[i] == 1)
			{   
				a[count1] = 1;
				count1++;
				
			}

		}
		
		display(a);

		}

	private static void display(int[] a) {
		for(int i = 0 ; i < a.length ; i++)
			System.out.print(a[i]+" ");
	}

	private static int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
		
		
	}
	
}
