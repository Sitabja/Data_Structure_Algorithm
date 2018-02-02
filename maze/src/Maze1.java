
public class Maze1 {
	static int arr[][]={{0,0,1,1,3,1},
		{0,1,1,1,0,1},
		{2,0,0,1,0,1},
		{0,1,1,1,0,1},
		{0,1,0,1,0,1},
		{0,1,0,1,0,1},
		{0,0,0,0,0,0}};
	static int rowS;
	static int columnS;
	static int rowE;
	static int columnE;
	static boolean flag = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rowS=2;
		columnS = 0;
		rowE=0;
		columnE=4;
		solveMaze(rowS,columnS,rowE,columnE,arr);
		arr[rowE][columnE]=3;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}

	}


	private static void solveMaze(int rowS2, int columnS2, int rowE2,
			int columnE2,int arr[][]) {
		
		if(rowS2==rowE2 && columnS2==columnE2)
		{
			flag=true;
			return;
		}
		
		
		int poss[][]=new int[4][2];
		for(int i=0;i<4;i++)
			poss[i][0]=poss[i][1]=-1;
		
		
		int r,c;
		
		r=rowS2-1;    //top
		c=columnS2;
		
		if(!(r<0 || arr[r][c]==1 || arr[r][c]==2 || arr[r][c]==4))
		{
			poss[0][0]=r;
			poss[0][1]=c;
		}
		
		r=rowS2;
		c=columnS2+1;  //right
		
		if(!(c>=arr[r].length || arr[r][c]==1 || arr[r][c]==2 || arr[r][c]==4))
		{
			poss[1][0]=r;
			poss[1][1]=c;
		}
		
		r=rowS2;
		c=columnS2-1;  //left
		
		if(!(c<0 || arr[r][c]==1 || arr[r][c]==2 || arr[r][c]==4))
		{
			poss[2][0]=r;
			poss[2][1]=c;
		}
		
		r=rowS2+1;
		c=columnS2;  //down
		
		if(!(r>=arr.length || arr[r][c]==1 || arr[r][c]==2 || arr[r][c]==4))
		{
			poss[1][0]=r;
			poss[1][1]=c;
		}
		
		for(int i=0;i<4;i++)
		{

			if(poss[i][0]!=-1)
			{
				arr[poss[i][0]][poss[i][1]]=4;
				solveMaze(poss[i][0],poss[i][1],rowE2,columnE2,arr);
				if(!flag)
					arr[poss[i][0]][poss[i][1]]=0;
					
			}
			
			if(flag)
				break;

		}
	}

}
