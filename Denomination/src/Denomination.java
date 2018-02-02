import java.util.Scanner;


public class Denomination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		int[] temp = new int[amount+1];
		temp[0] = 1;
		
	
		for(int i = 1; i <= amount ; i++){
			temp[i] += temp[i-1];
		}
		for(int i = 3; i <= amount ; i++){
			temp[i] += temp[i-3];
		}
		
		for(int i = 5; i <= amount ; i++){
			temp[i] += temp[i-5];
		}
		System.out.println();
		System.out.println("number of ways :"+temp[amount]);
	}
	

}
