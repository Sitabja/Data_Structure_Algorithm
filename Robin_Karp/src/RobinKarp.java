
public class RobinKarp {
	public static void main(String[] args) {
		match("ABC","ABABCABC");
	}
	
	public static void match(String pattern,String text) {
		
		int p = 0;
		int t = 0;
		int h = 1;
		int d = 26;
	
		h = (int)Math.pow(d,pattern.length()-1)%7;
	
		for(int i = 0 ; i < pattern.length() ; i++)
		{
			p = (d*p + pattern.charAt(i))%7;
			t = (d*t + text.charAt(i))%7;
		}
		
		for(int i = 0 ; i <= text.length() - pattern.length() ; i++)
		{
			if( p == t )
			{  int j = 0;
				for( j = 0 ; j < pattern.length() ; j++)
					if(pattern.charAt(j) != text.charAt(i+j))
						break;
				if( j == pattern.length() )
					System.out.println("match found at "+i);
			}
			
			if(i < text.length() - pattern.length() )
			{
				t = (d*(t - h*text.charAt(i))+text.charAt(pattern.length()+i))%7;
				if( t < 0)
					t += 7;
			}
		}
	}

}
