import java.awt.Point;
import java.awt.PrintGraphics;


public class EightQueens {
	private int[][] grid=new int[8][8];
	int count=0;
	int columnno=0;
	boolean flag;
	
	
	public void queens(int row,int column)
	{ 
		//System.out.println("row "+row+" column "+column);
	
		flag=false;
		if(count==8)
			{
			printGrid();
			return;
			}
		if(count==0)
		{
			grid[row][column]=++count;
			columnno=column;
			flag=true;
		}
	// System.out.println(count);
		
		for(int i=0;i<8;i++)          
			{
				if(grid[count][i]==0 && count!=0)
				{ 
					grid[count][i]=++count;
					columnno=i;
					//flag=true;
					for(int m=0;m<8;i++)
						for(int j=0;j<8;j++)
						{
							if(m==count-1 || m==columnno)
								if(grid[m][j]==0)
								  grid[m][j]=-1;
							for(int k=1;k<8;k++)
								if(m==count-1+k && j==columnno+k || m==count-1+k && j==columnno-k)
			                    	 if(grid[m][j]==0)
			       					  grid[m][j]=-1;
							     
			                    	 
						}
					  queens(count-1,columnno);
					
				
				}
				
			}
		
		if(flag==true)
		{ /*for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				if(i==count-1 || j==columnno)
					if(grid[i][j]==0)
					  grid[i][j]=-1;
				for(int k=1;k<8;k++)
					if(i==count-1+k && j==columnno+k || i==count-1+k && j==columnno-k)
                    	 if(grid[i][j]==0)
       					  grid[i][j]=-1;
				     
                    	 
			}*/
	
		
		}
	else
		{ 
			count--;
			//grid[count][columnno]=-1;
			
		}
		//System.out.println(columnno);
		printGrid();
		

	
		
			
	}


	private void printGrid() {
System.out.println("count: "+count);
		
		for(int[] rows:grid)
		{	for(int b:rows)
			{ 
				System.out.print(b+"\t");
			}
			System.out.println();
		}
		System.out.println("\n");
	
	}
	
	public static void main(String[] args) {
		
		EightQueens eq=new EightQueens();
		/*for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{  eq.queens(i,j);
			  // eq.printGrid();
			  eq.grid=new int[8][8];
			  eq.count=0;
			}*/
		
		eq.queens(0,0);
	}
	
}
