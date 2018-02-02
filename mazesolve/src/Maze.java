import java.awt.Point;


public class Maze {
	static String grid[][] = {
							{"*","*","0","0","0","0"},
							{"0","*","0","*","0","*"},
							{"0","*","0","0","0","0"},
							{"0","0","0","*","0","0"},
							{"*","*","0","0","0","*"},
							{"*","*","*","*","*","*"},
						    } ;
	static Point moves[] = {
							new Point(1,0),
							new Point(0,1),
							new Point(-1,0),
							new Point(0,-1),
		
							};
	static int count = 1;
	static int mincount = grid.length*grid[0].length;
	
	public static void main(String[] args) {
	
		grid[3][0]="p";
		
		maze(3,0,0,5);
		
		System.out.println("shortest path "+mincount );
		
	}

	private static void maze(int srow, int scol, int erow, int ecol) {
		if( srow == erow && scol == ecol)
		{
			for(int i=0;i<grid.length;i++)
				{ for(int j=0;j<grid[0].length;j++)
						System.out.print(grid[i][j]+"       ");
			      System.out.println();
				}
			System.out.println("------------------------------------");
			
			if(count < mincount)
				mincount = count;
			System.out.println(" count "+count);
			return;
					
		}
	for(int i=0;i<moves.length;i++)
	{
		int nextrow = srow+moves[i].x;
		int nextcol = scol+moves[i].y;
		
		if(nextrow < 0 || nextrow >= grid.length)
		  	continue;
		else if(nextcol < 0 || nextcol >= grid[0].length)
			continue;
		else if(!grid[nextrow][nextcol].equals("0"))
			continue;
		else
		{
			count++;
			grid[nextrow][nextcol] = "p";
			
			maze(nextrow,nextcol,erow,ecol);
			count--;
			grid[nextrow][nextcol] = "0";
			
			
		}
		
		  	
	}
		
	}
	

}
