package FidelityInvestment;

public class findLargestSubMatrix {
	public static void main(String[] args) {
		String[] arr = {"4"};
		max_size(arr);	
	}

	private static void max_size(String[] arr) {
		int size = Integer.parseInt(arr[0]);
		int[][] arr1 = new int[size][arr[1].length()/2 -1];
		for(int i = 0 ; i < size ; i++){
			for(int j = 0 ; j < arr[i].length();i++){
				if(arr[i].charAt(j) != ' '){
				arr1[i][j] = arr[i].charAt(j);
				}
			}
		}
		int r = arr1.length;
		int c = arr1[0].length;
		int[][] tab = new int[r][c];
		
		 for(int j = 0; j < c; j++) {
		     tab[0][j] = arr1[0][j];
		 }
		 
		 for(int i = 1; i < r; i++)
		  {
		    for(int j = 1; j < c; j++)
		    {
		      if(arr1[i][j] == 0) 
		        arr1[i][j] = min(arr1[i][j-1], arr1[i-1][j], arr1[i-1][j-1]) + 1;
		      else
		        tab[i][j] = 0;
		    }    
		  }
		 int maxRegion = 0, max_i = 0 , max_j = 0 ;
		 for(int i = 0 ; i < r; i ++) {
			 for(int j = 0 ; j < c ; j++){
				 if(tab[i][j] > maxRegion){
					 maxRegion = tab[i][j];
					 max_i = i;
					 max_j = j;
				 }
			 }			 
		 }
		 
		 int noOfPlace = (max_i - maxRegion)*(max_j - maxRegion);
		 int percentage = (noOfPlace/r*c)*100;
		 String output = noOfPlace+" "+percentage;
		      
		
		
		
		
	}

	private static int min(int a, int b, int c)
	{
	  int m = a;
	  if (m > b) 
	    m = b;
	  if (m > c) 
	    m = c;
	  return m;
	}

}
