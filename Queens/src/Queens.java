import java.util.Scanner;


public class Queens {

	static int pos[];
    static String grid[][];
    static int count = 0;
    static int noofsolutions = 0;
    public Queens(int n)
    {
    	grid = new String[n][n];
    	pos = new int[n];
    	for(int i=0;i<n;i++)
    	{
    		pos[i] = -1;
    		for(int j=0;j<n;j++)
    			grid[i][j]="*";
    		
    	}
    }
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		 Queens q = new Queens(n);
		 placequeen(n,0,0);

	}
    public static boolean canplace(int n,int r,int c)
    { 
    	for(int i=0;i<n;i++){
    		if(pos[i]!=-1 && (pos[i] == c || (i-r) == (pos[i]-c) || (i-r) == (c-pos[i])) ){
    			return false;
    		}
    			
    	}
    	return true;
    }           
    
	private static void placequeen(int n, int r, int c) {
	
		if( r >= n)
		{
			noofsolutions++;
			System.out.println(" solution :: "+noofsolutions);
			for(int i=0;i<n;i++)
				{ 
				 	for(int j=0;j<n;j++)
				 		System.out.print(grid[i][j]+"	");
				 	System.out.println();
				 	
				} 
				System.out.println("---------------------------");	
				return;
		}
		
		for(int i=0;i<n;i++)
		{
			int nextcol=c+i;
			if(nextcol >= n)
				continue;
			if(!canplace(n, r, nextcol)) 
				continue;
			else
			{
				pos[r] = i;
				count++;
				grid[r][nextcol] = "Q"+count;
				r++;
				
				placequeen(n, r, 0);
				
				count--;
				r--;
				pos[r] = -1;
				grid[r][nextcol] = "*";
				
			}
		}
	}

}
