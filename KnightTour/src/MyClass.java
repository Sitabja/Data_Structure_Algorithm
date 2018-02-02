import java.awt.Point;


public class MyClass {
	private int[][] grid;
	private int count,spaces;
	private boolean flag;

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
	public MyClass(int rows,int columns)
	{
		grid=new int[rows][columns];
		spaces=rows*columns;
		count=0;
	}

	private void printGrid()
	{
		System.out.println("count: "+count);
		
		for(int[] rows:grid)
		{	for(int b:rows)
		{ System.out.print(b+"\t");
		}
		System.out.println();
		}
		System.out.println("\n");
	}
	
	public void tourFrom(int row,int col)
	{	//printGrid();
		if(count==spaces)
		{
			printGrid();
			flag = true;
			return;
		}
		if(count==0)
		{
			grid[row][col] = ++count;
		}
		
		for(Point p:moves)
		  {
			  int nextRow=row+p.x;
			  int nextCol=col+p.y;
			  if(nextRow<0 || nextRow>=grid.length)
				  continue;
			  else if(nextCol<0 || nextCol>=grid.length)
				  continue;
			  else if(grid[nextRow][nextCol] != 0)
				  continue;
			  else
			  {
				  grid[nextRow][nextCol] = ++count;
				  
				  tourFrom(nextRow,nextCol);
				  
				  grid[nextRow][nextCol] = 0;
				  count--;
			  }
		  }
		
	}
	
	public static void main(String[] args) {
		MyClass tour=new MyClass(5,5);
		System.out.println("Starting...");
		for(int i= 0;i<tour.grid.length;i++)
			for(int j=0;j<tour.grid[0].length;j++)
			{
				tour.flag = false;
				tour.tourFrom(i,j);
				if(!tour.flag)
				{
					System.out.println("No solution for starting at "+i+","+j);
				}
				else
					System.out.println("solution for starting at "+i+","+j);
				tour.grid[i][j]=0;
				tour.count=0;
				
			}
		
		
			
	}



}
