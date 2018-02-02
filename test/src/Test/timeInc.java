package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class timeInc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

	}
	
	static String closestNumbers(int len, String s) {
		String[] a = s.split(" ");
		List<Integer> arr = new ArrayList<Integer>();
		for(int i = 0 ; i < len ; i++){
			arr.add(Integer.parseInt(a[i]));
		}
		Collections.sort(arr);
		int min = Integer.MAX_VALUE;
		String output = "";
		for(int i = 0 ; i < len - 1 ; i++){
			int diff =(int)(Math.abs(arr.get(i) - arr.get(i+1)));
				if(diff < min){
					min = diff;
				}
			}
		for(int i = 0 ; i < len ; i++){
			int diff =(int)(Math.abs(arr.get(i) - arr.get(i+1)));
			if(diff == min){
				min = diff;
				output += arr.get(i)+" "+arr.get(i+1)+" ";
			}
		}
		
		return output;


    }


}
