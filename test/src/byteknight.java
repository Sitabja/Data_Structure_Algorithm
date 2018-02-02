
public class byteknight {
	
	public static void main(String srg[])
	{  
		long a =(System.currentTimeMillis());
		int arr[][]={{1,2},{0,0},{1,3}};
	
		 no_knights(arr.length,arr);
		 
		System.out.println((System.currentTimeMillis()-a));
	}
  
	public static void no_knights(int totalpopulation,int ans[][])
	{  
		int []v;
		boolean flag=false;
		for(int i=0;i<=totalpopulation;i++)
		{
			v=new int[totalpopulation];
			int count = 0;
			for(int j=0;j<totalpopulation;j++)
			{
				if(ans[j][0]<=i && i<=ans[j][1])
				{
					count++;
					v[j]=1;
				}
			}
			if(count==i)
			{  flag=true;
				for(int j=0;j<totalpopulation;j++)
					System.out.print(v[j]+" ");
				System.out.println();
			}
			
		}
		
		if(!flag)
		{
			System.out.println("cannot be determined");
		}
		
	
	}
}
