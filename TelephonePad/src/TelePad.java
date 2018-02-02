import java.awt.Point;


public class TelePad {
	private static String s = "";
	private static int count = 0;
	public static void main(String[] args) {
		char[][] grid = {
				{'1','2','3'},
				{'4','5','6'},
				{'7','8','9'},
				{'*','0','#'}};
	Point[] point = {
			new Point(1,1),
			new Point(1,-1),
			new Point(-1,1),
			new Point(-1,-1),
	};
	
	s += grid[1][1];
	generate(grid,point,1,1);
	System.out.println(count);
	
	}

	private static void generate(char[][] grid, Point[] point, int i, int j) {
		if(s.length() == 6) {
			System.out.println(s);
			count++;
			return;
		}
		for(Point p : point) {
			int row = i + p.x;
			int col = j + p.y;
			
			if(row < 0 || row >= grid.length)
				continue;
			if(col < 0 || col >= grid[0].length)
				continue;
			if(grid[row][col] != '#' && grid[row][col] != '*') {
				s+=grid[row][col];
				generate(grid,point,row,col);
				s =s.substring(0,s.length()-1);
			}
		}
		
	}
}
