import java.util.Date;


public class AP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
     String s="1 3 5 7 11 25 37 56 9 87 100 104 108 115 111 156 200 207 209 1000";
     s+=" ";
     
     String[] s1=s.split(" ");
     
     int[] in  = new int[s1.length];
     
    
    for(int i=0; i < s1.length ; i++)
    	in[i] = Integer.parseInt(s1[i]);
    
    int l = 0;
    int first,second;
    String output="";
    //System.out.println(s.substring(s.indexOf(" "+9+" ")));
    long d = new Date().getTime();
  for(int i=0 ; i<in.length-2;i++)
	  for(int j=i+1 ; j<in.length-1; j++)
	  {  first = in[i];
	     second = in[i+1];
	     
	     l = 0;
	     output = first+" "+second;
	     int m =  2*second-first;
		  boolean flag = false;
		while(s.substring(s.indexOf(" "+second+" ")+1).contains(" "+m+" "))
		  { 
			 //System.out.println(2*second-first+" "+m);
			 
			 first = second ;
			 second = m;
			 
			  output+=" "+second;
			  //System.out.println(output);
			  
			  m = 2*second-first;
			  flag =true;
		  	}
			
		  if(flag)
		   System.out.println(output);
	  }   
  long d1 = new Date().getTime();
  
  System.out.println(d1 - d);
	}
	 

}
