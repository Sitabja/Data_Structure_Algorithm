
public class Bin {
        public static void main(String[] args) {
			System.out.println(binomial(6, 4));
		}
        
        private static int binomial(int n, int m)
        {  int[] b = new int[n+1];
           b[0] = 1 ;
           
           for(int i = 1 ; i <= n ; i++)
           {  b[i] = 1 ;
           		for(int j = i - 1 ; j > 0 ; j--)
           		{
           			b[j] += b[j -1];
           			
           			System.out.print(b[j]+" ");
           		}
           		 System.out.println();
           }	
           
           /*for(int i = 0 ; i < b.length ; i++)
           {
        	   System.out.print(b[i]+"  ");
           }*/
        	   
			return b[m];
        	
        }
}
