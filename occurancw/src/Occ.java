import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class Occ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "abcdaaaa";
		int count=1;
		Map<Character,Integer> m = new TreeMap<Character, Integer>();
		char ch[]=s.toCharArray();
		for(int i=0;i<ch.length;i++)
		{ count = 1;
			 for(int j=i;j<ch.length-1;j++)
				if(ch[i]==ch[j+1])
				{ System.out.println("here ::" +ch[j+1]);
					
					count++;
				}
		
			 m.put(ch[i],count);
			   
			
		}
		
	Set<Character> s1 = m.keySet();
		
		for(Character i: s1)
		{
			System.out.println(i+"--"+m.get(i));
		}
	}

}
