import java.util.Scanner;


public class Solutions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			long d=sc.nextLong();
			long k=sc.nextLong();
			long count=0;
			calculation(d,k,count);
		}
	}
	public static void calculation(long d,long k,long count)
	{
		double r=Math.sqrt(d);
		for(int j=0;j<=r;j++){
			double round=Math.round(Math.sqrt(d-j*j));
			double sqrt1=Math.sqrt(d-j*j);
			if(round==sqrt1)
			{
				if(j==0 || j==r)
					count=count+2;
				else count=count+4;
			}
		}
		//System.out.println(count);
		if(count<=k)
			System.out.println("possible");
		else System.out.println("impossible");
	}

}
