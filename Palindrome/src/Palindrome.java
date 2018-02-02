import java.util.ArrayList;


public class Palindrome {
	static int max = 0;
	static int p = 0;
	public static void main(String[] args) {
	String[] arr = {"A","A","A","A","C","D","A"}; //{ "Bharati","Bharat","Akash","Bhabia","Chand","Bijesh","Chetak","Arvind","Bhabna" };
		
	String s = "";
	for(int i = 0 ; i < arr.length ; i++)
	{
		s+=arr[i].charAt(0);
	}
		
		LCS_Palindrome(s,arr.length);
	
		if(s.length()%2 != 0)
			if((s.charAt(s.length()/2) == s.charAt(s.length()/2 - 1 ) ||
					s.charAt(s.length()/2) == s.charAt(s.length()/2 + 1 )) &&
					( s.charAt(s.length()/2 - 1) != s.charAt(s.length()/2 + 1 )))
				max++;
		
		if(max == 0)
			System.out.println(1);
		else
			System.out.println(max);
		
		
        	
		
	}

	private static void LCS_Palindrome(String s , int m) {
	
		String x = "";
		String y = "";
		
		/*String x = "abc";
		String z = "dba";*/
		if(s.length() == 1)
		{
			
			return ;
		}
		
		
		for(int i = 0 ; i < s.length()/2 ;i++)
		{
			x += s.charAt(i)+"";
			y += s.charAt(s.length() - i - 1)+"";
		 
		}
	
		
	
		int M = x.length();
		int N = y.length();
		int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

      /*  for(int i = 0 ; i< opt.length ; i++ )
        	{ 
        	  for( int j = 0 ; j< opt[0].length ; j++)
        	
        		 {
        		       System.out.print(opt[i][j]+" ");
        		 }
        	  System.out.println();
        	}  */
        
     /*   int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) 
            	i++;
            else                                 
            	j++;
        }
        System.out.println();*/
        p += opt[0][0]*2;
        System.out.println(x +" "+ y + " "+s.charAt(s.length()/2));
        System.out.println((x.charAt(x.length() - 1 ) != y.charAt(y.length() - 1 )));
        System.out.println(p);
        
       if((x.charAt(x.length() -1 ) == s.charAt(s.length()/2) ||
        		y.charAt(y.length() - 1 ) == s.charAt(s.length()/2))
        		&& (x.charAt(x.length() - 1 ) != y.charAt(y.length() - 1 )))
        		max++;
        

       
        if(opt[0][0] == 0)
        {   x = x;
        	y = y;
        	LCS_Palindrome(x,x.length());
        	LCS_Palindrome(y, y.length());
        	
        }
        
        else if(m % 2 == 0)
        {  
        	LCS_Palindrome(x,x.length());
        	LCS_Palindrome(y, y.length());
        	if(max < opt[0][0]*2)
        		max = opt[0][0]*2;
        
        	return;
        }
        
        else if(m % 2 != 0)
        {  LCS_Palindrome(x,x.length());
    	LCS_Palindrome(y, y.length());
        	if (max < opt[0][0]*2 + 1)
        		max = opt[0][0]*2 + 1;
        	return;
        }
		
	}

	private static String reverse(String z) {
		String y = "";
		for(int i = 0 ; i < z.length() ; i++)
		{
			y += z.charAt(z.length() - i - 1 );
		}
			
		return y;
	}

}
