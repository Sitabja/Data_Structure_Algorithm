
public class eggDrop {
	public static void main(String[] args) {
		int noOfEggs = 100;
		int noOfFloors = 500;
		
		possibleAttempts(noOfEggs,noOfFloors);
		
	}

	private static void possibleAttempts(int noOfEggs, int noOfFloors) {
		
		int tab[][] = new int[noOfEggs+1][noOfFloors+1];
		for(int j = 1 ;j <= noOfFloors ; j++ )
			tab[1][j]=j;
		for(int  i = 2 ; i <= noOfEggs ; i++)
			for(int j = 1 ; j <= noOfFloors; j++ ) {
				if(j<i)
					tab[i][j] = tab[i-1][j];
				else {
					int min = Integer.MAX_VALUE;
				for(int k = 1 ; k <= j ; k++){
					int max = 1 + Math.max(tab[i-1][k-1],tab[i][j-k]);
					if(min > max)
						min = max;	
			}
				tab[i][j] = min;
				}
		}
		for(int i = 0 ; i < tab.length ; i++ ){
			for(int j = 0; j < tab[0].length; j++)
				System.out.print(tab[i][j]+"\t");
			System.out.println();
		}
		System.out.println(tab[noOfEggs][noOfFloors]);
	}
	

}
