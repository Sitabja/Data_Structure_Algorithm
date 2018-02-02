import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
static void nextMove(int n, int r, int c, String [] grid){
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
    
    if(pcol < c)
        System.out.println("LEFT");
          
    else if(pcol > c)
        System.out.println("RIGHT") ;
   
   else if(prow < r)
        System.out.println("UP");
  
   else if(prow > r)
        System.out.println("DOWN");
    
   
  }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
       // in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);

    }
}
