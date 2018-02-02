import java.util.Scanner;


public class Pascal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc=new Scanner(System.in);
		System.out.println("enter the order...");
		int p=sc.nextInt();
		int n=p-1;
		int number=1;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				System.out.print(" ");
			}
			
		
			for(int k=0;k<=i;k++)
			{
				
				number=(int)(fact(i)/(fact(k)*fact(i-k)));
				System.out.print(number+" ");
				
			}
			System.out.println();
		}*/
		Scanner s=new Scanner(System.in);
		System.out.println("enter the row number");
		int row=s.nextInt();
		float sum=(fact(2)*fact(2))/fact(4);
		for(int i=5;i<=row;i++)
		{
			for(int j=2;j<=i-2;j++)
			sum+=(fact(j)*fact(i-j))/fact(i);
		}
		
		
		
		System.out.println("sum is :: ["+Math.round((sum)*10.0)/10.0+"]");
	}
	
	public static float fact(int n)
	{
		if(n==0)
			return 1;
		else 
			return n*fact(n-1);
	}
		//Scanner s=new Scanner(System.in);
		
	/*public static String  convert(float sum)
	{
		String ss = sum + "";
		int index = ss.indexOf(".");
		if(ss.length()>=index+1)
		{	
			int num = Integer.parseInt(ss.charAt(index + 2)+"");
			if(num>=5)
			{
				num = Integer.parseInt(ss.charAt(index + 1)+"")+1;
				if(num==10)
				{
					ss = "1.0";
				}
				else
				{
					ss="["+"0."+num+"]";
				}
			}
		}
		return ss;
	}*/
}
