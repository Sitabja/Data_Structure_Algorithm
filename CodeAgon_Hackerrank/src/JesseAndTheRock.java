import java.util.Scanner;


public class JesseAndTheRock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int count = 0;
		for(int i = 0 ; i < n ; i ++){
			a[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < n ; i ++){
			if(a[i] > m) {
				count++;
			} if(count > 1){
				System.out.println(i - 1);
				return;
			}
		}
		if(count == 1){
			System.out.println(n - 1);
		} else {
			System.out.println(n);
		}
		
	}

}
