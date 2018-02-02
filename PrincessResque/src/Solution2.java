
	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class Solution2 {
	static void displayPathtoPrincess(int n, String [] grid){
	     
	    int r = n /2;
	    int c = n/2 ;
	     int prow = 0;
	    int pcol = 0;
	    for(int i = 0 ; i < n ; i++)
	      
	        {
	           if(grid[i].contains("P"))
	               {
	                     prow = i ;
	                     pcol = grid[i].indexOf("P") ;
	                      
	                     break;
	                }
	        } 
	    while(r != prow || c != pcol)
	   {
	      if(pcol < c)
	      {
	          System.out.println("LEFT");
	          c--;
	      }
	          
	    else if(pcol > c)
	       {
	        
	            System.out.println("RIGHT") ;
	            c++;
	      }
	   
	   else if(prow < r)
	       {
	          System.out.println("UP");
	          r--;
	        }
	  
	   else if(prow > r)
	       {
	        System.out.println("DOWN");
	         r++;
	        }
	    
	       }
	   
	  }
	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int m;
	        m = in.nextInt();
	        String grid[] = new String[m];
	        for(int i = 0; i < m; i++) {
	            grid[i] = in.next();
	        }

	    displayPathtoPrincess(m,grid);
	    }
	}


