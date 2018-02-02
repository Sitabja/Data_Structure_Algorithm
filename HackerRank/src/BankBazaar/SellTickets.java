package BankBazaar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SellTickets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i= 0 ; i < n; i++){
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		int length = list.size();
		int sum = 0;
		for(int i = length - 2 ; i >= 0 ; i--){
			int ele1 = list.get(i);
			while(list.get(length-1) != ele1){
			for(int j = i+1 ; j <= length - 1 ; j++){			
					if(m == 0){
						System.out.println(sum);
						return;
					}
					int ele2 = list.get(j);
					sum += ele2;
					list.set(j,--ele2);
					m--;
				}
			}	
		}
		
		
			for(int j = 0 ; j <= length - 1 ; j++){
				int ele2 = list.get(j);
				while(m > 0 && ele2 != 0){	
					sum += ele2;
					list.set(j,--ele2);
					m--;
					ele2 = list.get(j);
				}
				if(m == 0){
					System.out.println(sum);
					return;
				}
			}	
			System.out.println(sum);

	}
}
