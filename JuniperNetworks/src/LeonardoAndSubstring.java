import java.util.Scanner;


public class LeonardoAndSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i++){
			String s = sc.next();
			int l = s.length();
			int possibleSubString = l*(l+1)/2;
			for(int j =0 ;j < l - 1;){
				char x = s.charAt(j);
				int k = 1;
				int count = 1;
				boolean flag = false;
				while (j+k < l && s.charAt(j+k) == x ){
					count++;
					k++;
				}
				if(count > 1){ 
					possibleSubString -= (count*(count+1)/2 - count + j);
					flag = true;
				}
				if(flag){
					possibleSubString--;
				}
				j = j+k;
				
			}
			System.out.println(possibleSubString);
		}

	}

}
