
public class KnapSack {
	public static void main(String[] args) {
		int val[] = {1,20,30,5};
		int wt[] = {1,3,4,7};
		int w = 7;
		knapSack(val,wt,w);
		
	}

	private static void knapSack(int[] val, int[] wt, int w) {
		String s = "";
		int tab[][] = new int[wt.length+1][w+1];
		for(int i = 1; i < tab.length ; i++ )
			for(int j = 1 ; j < tab[0].length;j++) {
				if(j>=wt[i-1])
					tab[i][j] = Math.max(val[i-1]+tab[i - 1][j-wt[i-1]],tab[i-1][j]);
				else
					tab[i][j] = tab[i-1][j];
			}
		System.out.println(tab[tab.length-1][tab[0].length-1]);
		
		int i = tab.length -1 , j = tab[0].length-1;
		while(i >= 0 && j >= 0){
				if(tab[i][j] == tab[i-1][j])
					i--;
				else
				{
					s = wt[i-1]+" "+s;
					j = j - wt[i-1];
					i--;
					
				}
				if( j == 0 )
					break ;
			}
			System.out.println(s);
		}
	}

