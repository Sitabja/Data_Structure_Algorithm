import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Level1 {
	
	private static int count;
	public static void main(String[] args) {
		int input1[] = {4,6};
		int input2[] = {1,3,0,0,0,0,0,0,4,5,1,0,0,0,0,6,7,6,0,0,0,0,5,0};
		System.out.println(solution(input1,input2));
		
	}
	public static int solution(int input1[],int input2[])
	{   int r = input1[0];
		int c = input1[1];
		int[][] grid = new int[r][c];
		Map<Integer,Point[]> position = new HashMap<Integer,Point[]>();
		
	  int j = 0 ; 
		for(int i = 0 ; i < input2.length ; i ++)
		{    
			int k = i%c;
			
			grid[j][k] = input2[i];
			if(k == c - 1){
				j++;
			}
			
			  
			int x = input2[i];
			Point p1[];
			switch(x){
			case 0 : p1 = new Point[]{
					};
					position.put(0,p1);
			
			case 1:  p1 = new Point[]{
					new Point(0,1),
					};
					position.put(1,p1);
			case 2: p1 = new Point[]{
					new Point(1,0),
					};
					position.put(2,p1);
					
			case 3: p1 = new Point[]{
					new Point(1,1),
					};
					position.put(3,p1);
			case 4:  p1 = new Point[]{
					new Point(0,1),
					new Point(1,0)
					};
					position.put(4,p1);
			case 5:  p1 = new Point[]{
					new Point(0,1),
					new Point(1,1)
					};
					position.put(5,p1);
			case 6: p1 = new Point[]{
					new Point(1,0),
					new Point(1,1)
					};
					position.put(6,p1);
			case 7: p1 = new Point[]{
					new Point(1,0),
					new Point(1,1),
					new Point(0,1)
					};
					position.put(7,p1);
								
					
					
			}
			
				
		}
		
		
		 findNoofWays(grid,0,0,position);
		 return count;
		
		
	}
	private static void findNoofWays(int[][] grid,int r, int c, Map<Integer, Point[]> position) {
		int x = grid[r][c];
		
		Point[] p = position.get(x);
		
		for(int i = 0 ; i < p.length ; i++){
			int nextRow = r + p[i].x;
			int nextCol = c + p[i].y;
			if(nextRow == grid.length - 1 && nextCol == grid[0].length - 1)	
			{	//System.out.println(r+" "+c);
				count++;
				
			
			}
			
			if(nextRow == grid.length)
				continue;
			else if(nextCol == grid[0].length)
				continue;
			if(grid[nextRow][nextCol] == 0)
				continue;			
			else {
				
				findNoofWays(grid,nextRow,nextCol,position);
			}
		}
		
		    	
		
		
	}
}
