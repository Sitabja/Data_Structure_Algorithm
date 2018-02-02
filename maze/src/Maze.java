
public class Maze {
	static int arr[][]={{0,0,1,1,0,1},
		             {0,1,1,1,0,1},
		             {0,0,0,1,0,1},
		             {0,1,1,1,0,1},
		             {0,1,0,1,0,1},
		             {0,1,0,1,0,1},
		             {0,0,0,0,0,0}};
    static int rowS;
    static int columnS;
    static int rowE;
    static int columnE;
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rowS=2;
        columnS = 0;
        rowE=0;
        columnE=4;
        solveMaze(rowS,columnS);
        
        
        
        
	}


	private static void solveMaze(int rowS2, int columnS2) {
		boolean flag=false;
		
		for(int i=rowS2;i<arr.length;i++)
			for(int j=columnS2;j<arr[0].length;j++)
			{  /*if(i==-1)
			 {
				System.out.println("not found");
				return;
			 }*/
				/*if(i==arr.length-1)
				{
				    flag=true;
					i=rowS2-1;
				}*/
			 if(arr[i][j]==0)
				{
				  if(i==rowE && j==columnE)
				  {
					  System.out.println("found");
					  return;
				  }
				  else
					solveMaze(i,j);
				}
			
				
			/*else if(arr[i][j]==1 )
				{ 
				  if(!flag)
					i++;
				  else
					 i--;
				}*/
			
			 
			}
		
	}

}
