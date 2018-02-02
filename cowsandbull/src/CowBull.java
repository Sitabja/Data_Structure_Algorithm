import java.util.Scanner;


public class CowBull {
public static void main(String[] args) {
	String sWord = "";
	while(sWord!="done")
	{ Scanner sc=new Scanner(System.in);
	
	 sWord=sc.next();
	int cows=sc.nextInt();
	int bulls=sc.nextInt();
   String cbull = "";
	if(bulls==1)
   for(int i=0;i<4;i++)
	{
		if(!cbull.contains(sWord.charAt(i)+""))
		{
			cbull+=sWord.charAt(i);
		}
	}
	
	}
	
	
}
}
