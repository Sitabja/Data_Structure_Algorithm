
public class CycleDetection {
	static int arr[][]={{1,1,0,0,1,0},{0,0,1,1,0,0},{0,0,0,1,0,1},{1,0,0,0,0,0},{1,0,0,0,0,0},{0,0,1,1,0,0}};
	static int visited[]=new int[arr.length];
	static int count=0;
	static int startVertex;
	public static void main(String[] args) {
		
		String s="";
		
		for(int i=0;i<arr.length;i++)
		{	startVertex=i;
			for(int n=0;n<visited.length;n++)
				visited[n]=0;
			s=String.valueOf(i)+" -> ";
			//System.out.println(i+"->");
			cycleCount(i,s,visited);
			for(int j=0;j<arr.length;arr[i][j]=0,j++);
		}
		System.out.println("Cycle "+count);
	}
	
	public static void cycleCount(int i,String s,int visited[])
	{
		visited[i]=1;
		int v[]=new int[visited.length];
		for(int k=0;k<v.length;k++)
			v[k]=visited[k];
		
		String s1=new String("");
		for(int j=0;j<arr.length;j++)
		{	
			
			if(arr[i][j]==1 && startVertex==j)
			{	
				System.out.println("found:"+i+" "+j);
				s1=s+String.valueOf(j);
				//arr[i][j]=0;
				System.out.println(s1);
					count++;
			}
			else if(arr[i][j]==1)
			{	
				System.out.println(i+" "+j);
				s1=s+String.valueOf(j)+" -> ";
				if(v[j]==1)
				{  System.out.println("v");
					for(int m=0;m<v.length;m++)
					System.out.print(v[m]);
					System.out.println();
					
					continue;
				}
				cycleCount(j,s1,v);
			}
		}
	}
	
}
