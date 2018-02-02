package Test;

import java.util.Scanner;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[]={0,0,1,3};
		int max = a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
			}
		}
		//System.out.println(max);
		int freq[]=new int[max+1];
		
		for(int i=0;i<freq.length;i++)
			freq[i] = 0;
		
		for(int i = 0;i<a.length;i++ )
			freq[a[i]] ++;
		int sum=freq[0];
		for(int i=0;i<freq.length;i++)
			{
			if(sum==0 && i==0)
				{System.out.println("0");//Not possible
				 return;
				}
			else if(sum<i)
					{System.out.println("0");
					 return;
					}
			sum+=freq[i];
			
			}
			
		
		int i=0,count=freq[0];int noOfPosCom=freq[0];
		
		while(++i<=max || count>1)
			{	
			//System.out.println("\n Count :" +count+" No of pos comb: "+noOfPosCom+ " \n");
			if(i<=max)
			count = (--count) + freq[i];
			else 
				count--;
			
			noOfPosCom*=count;
			}
		//System.out.println("No. of possible combinations: "+ noOfPosCom);
		System.out.println(noOfPosCom);
		
	}

}
