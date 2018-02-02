import java.util.Scanner;


public class Panda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int number=sc.nextInt();
			prime(number);
		}
		
	}
	public static void prime(int number)
	{
		for(int n=0;n<Math.sqrt(number);n++)
		{
			
		}
	}

}
