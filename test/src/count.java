import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class count {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "aasjjikkk";
		
		char[] charArray = text.toCharArray();
		TreeMap<Character, Integer> freqList = new TreeMap<Character, Integer>();
		ArrayList<Integer>al=new ArrayList<Integer>();

		        for(char key : charArray) {
		            if(freqList.containsKey(key)) {
		               freqList.put(key, freqList.get(key) + 1);
		            } else
		                freqList.put(key, 1);
		        }
		        
		        Set<Character> keySet=freqList.keySet();
		        for( Character i : keySet)
		        	System.out.println(i+ " "+ freqList.get(i));
		        int arr[]=new int[freqList.size()];
		        for( Character i : keySet)
		        	al.add(freqList.get(i));
		        Collections.sort(al);
		        String s1="";
		        	System.out.println(al);
		        	for(int m=0;m<al.size();m++){
		        		for(int x=0;x<al.get(m);x++)
		        			{
		        			s1+=al.get(m);	
		        			}
		        		}
		        	System.out.println(s1);
		        	
					
		        	
	}
		        
	
}
