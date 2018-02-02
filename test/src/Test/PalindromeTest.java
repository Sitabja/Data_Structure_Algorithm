package Test;

import java.util.Scanner;

public class PalindromeTest {
	public static void main(String[] args) {
		String s = new Scanner(System.in).next();
		for (int i = 0, j = s.length()-1 ; i<j; i++, j-- ){
			if(s.charAt(i) != s.charAt(j)){
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
	}

}
