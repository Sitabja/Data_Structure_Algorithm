
public class Sort1sAnd2s {
	 public static void main(String[] args) {
		
		 int a[] = {1,2,2,2,1,1,2,1,2};
		 int count = 0;
		 
		 for(int i = 0 ; i < a.length ; i++)
		 {
			 if(a[i] == 1 && i == count)
				 count++;
			 else if (a[i] == 1 && i != count )
			 { a[count] = (a[count]+a[i]) - (a[i] = a[count]);
			 	count++;
			 }
		 }
		 
		 for(int i = 0 ; i < a.length ; i++)
		  System.out.print(a[i]+" ");
	}
	

}
