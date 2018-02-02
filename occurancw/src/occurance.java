import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class occurance {
	public static void main(String[] args) {
		String s="abacdceaaa";
		List<Character> l=new ArrayList<Character>();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		String s1="";
		//char[] s1=new char[s.length()];
		int[] in=new int[s.length()];
		
		for(int i=0;i<s.length();i++)
		{
			l.add(s.charAt(i));
		}
		
		for(int i=0;i<l.size();i++)
		{
			if(!s1.contains(s.charAt(i)+"")) 
			{  s1+= s.charAt(i);
		      in[i] = Collections.frequency(l,s.charAt(i));
		      //map.put(in[i], s.charAt(i)+"");
		      System.out.println(s.charAt(i)+" "+in[i]);	      
			}
		}
		
		/*Set<Integer> keySet=map.keySet();
		
		for(Integer i : keySet)
		{
			System.out.println(i+" "+map.get(i));
		}*/
		Arrays.sort(in);
		   for(int j=0;j<in.length;j++)
		      System.out.println(in[j]);
		  /* for(int j=0;j<in.length;j++){
			   if(in[i]!=0)*/
	/*for(int i=0;i<s1.length();i++)
	{ 
		System.out.println(s1.charAt(i)+" "+in[i]);
		
	}*/
}
	

}
