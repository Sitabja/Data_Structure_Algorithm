import java.util.Scanner;


public class MinNumberOfCoins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		int[] coins = {1,2,5};
		System.out.println("recursive solution : " + recursive(amount,coins));
		System.out.println("Dp solution : " + DP(amount,coins));
	}

	private static int DP(int amount, int[] coins) {
		int[] temp = new int[amount+1];
		if (amount <= 0)
			return 0;
		
		else {
			temp[0] = 0;
			for(int i = 1 ; i < temp.length ; i++)
				temp[i] = Integer.MAX_VALUE;
			
			for(int i = 1 ; i < temp.length ; i++) {
				
				for(int j = 0 ; j < coins.length ; j++){
					if(coins[j] <= i){
						int subMin = temp[i-coins[j]];
						if(temp[i] > subMin + 1) {
							temp[i] = 1+ subMin;
						}
					}
				}
				
			}
		}
			
		return temp[amount];
	}

	private static int recursive(int amount, int[] coins) {
		int min = Integer.MAX_VALUE;
		if ( amount <= 0 )
			return 0;
		
		else {
			for(int i = 0 ; i < coins.length ; i++) {
				int subMin;
				if(coins[i] <= amount){
					subMin = recursive(amount - coins[i],coins);
					if(subMin+1 < min)
						min = subMin + 1;
				}
				
			}
			
			}
		return min;
	}
			
		
}


