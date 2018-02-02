import java.awt.Point;


public class KnightTour {
	private boolean[][] grid;
	private int count,spaces;
	
	private static final Point[] moves=new Point[]{
		new Point(-2,-1),
		new Point(-2,1),
		new Point(2,-1),
		new Point(2,1),
		new Point(-1,-2),
		new Point(-1,2),
		new Point(1,-2),
		new Point(1,2),
	};
	public KnightTour(int rows,int columns)
	{
		grid=new boolean[rows][columns];
		spaces=rows*columns;
		count=0;
	}
  public void tourFrom(int row,int col)
  {
	  grid[row][col]=true;
	  count++;
	  
	  if(count==spaces)
	  {
		 // return true;
		  return;
	  }
	  for(Point p:moves)
	  {
		  int nextRow=row+p.x;
		  int nextCol=col+p.y;
		  
		  if(nextRow<0 || nextRow>=grid.length)
			  continue;
		  if(nextCol<0 || nextCol>=grid.length)
			  continue;
		  else if(grid[nextRow][nextCol])
			  continue;
		  else
		  {
			  grid[nextRow][nextCol] = true;
			  tourFrom(nextRow,nextCol);
			  
			  grid[nextRow][nextCol] = false;
			  count--;
		  }
		  
			  //return true;
	  }
	  
	  /*printGrid();
	  
	  grid[row][col]=false;
	  count--;
	  return false;*/
	  
		  
		  
	  }
private void printGrid()
{
	System.out.println("count: "+count);
	for(boolean[] rows:grid)
	{	for(boolean b:rows)
		{ System.out.print((b)? "T":"F");
		
		
		}
	System.out.println();
	}
	System.out.println("\n");
}	
	public static void main(String[] args) {
		KnightTour tour=new KnightTour(8,8);
		tour.tourFrom(0,0);
		tour.printGrid();
	}
	

  
  
  
}
