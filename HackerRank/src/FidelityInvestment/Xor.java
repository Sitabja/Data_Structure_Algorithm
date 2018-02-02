package FidelityInvestment;

import java.util.Scanner;

public class Xor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0 ; i < t ; i++){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int j = 0 ; j < n ;j++){
				a[j] = sc.nextInt();	
			}
			int leftXor = 0;
			int rightXor = 0;
			boolean flag = false;
	outer :		for(int j=0 ; j < a.length -1 ; j++ ){
				leftXor = leftXor ^ a[j];
				for(int k = j+1 ; k < a.length ; k++ ){
					rightXor ^= a[k];
				}
				if(leftXor == rightXor){
					flag = true;
					break outer;
				} else {
					rightXor = 0;
				}
			}
			if(flag){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
	}

}
