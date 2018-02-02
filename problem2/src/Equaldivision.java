import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Equaldivision {
String input="4#3,3,3,3#5,5,5,5";
String[] s=input.split("#");
int noofstudents=Integer.parseInt(s[0]);
String[] smax=s[2].split(",");
String[] smin=s[1].split(",");
int max[]=new int[s[1].length()];
int min[]=new int[s[1].length()];
int A[]=new int[noofstudents];
static String comb="";

static List<int []> l=new ArrayList<int []>();
static List<Integer> goaldiff=new ArrayList<Integer>();

public void equal()
{ 	for(int i=0;i<noofstudents;i++)
  	{  max[i]=Integer.parseInt(smax[i]);
  	   min[i]=Integer.parseInt(smin[i]);
	}

 bin(noofstudents);
}
public void bin(int n)
{ 	//System.out.println("n:"+n);
	if(n<2)
	{/*System.out.println("here::"); 
	for(int i=0;i<noofstudents;i++)*/
	  /* System.out.print(A[i]+",");*/
	 findteam(A);
	}
	
 else
 {
	 A[n-1]=0;
	 bin(n-1);
	 A[n-1]=1;
	 bin(n-1);
 }

}
private void findteam(int[] a2) {
	int a[] = new int[noofstudents];
	for(int i= 0;i<noofstudents;i++)
		{ 
			
			a[i] = a2[i];
		
		}
	
 

 int max1=0;
 int min1=0;
 int max2=0;
 int min2=0;
 int dif1,dif2;
 int flag0 = 0,flag1 = 0;
/* List<Integer> team0=new ArrayList<Integer>();
 List<Integer> team1=new ArrayList<Integer>();
 */
 for(int i=0;i<a2.length;i++)
 {
	if(a2[i]==1)
		flag1=1;
	if(a2[i]==0)
		flag0=1;
	
 }
 
 if(flag0==1 && flag1==1)
  { l.add(a);
	 for(int i=0;i<a2.length;i++)
	 {
		 if(a2[i]==1)
			 {//team1.add(i);
			  max1+=max[i];
			  min1+=min[i];
			 }
		 if(a2[i]==0)
			 {//team0.add(i);
			   max2+=max[i];
			   min2+=min[i];
			 }
		}
	 dif1=max1-min2;
		
		
	 dif2=max2-min1;
 
	 if(dif1>dif2 )
		 goaldiff.add(dif1);
	 else
		 goaldiff.add(dif2);
	
		
	 }
	 
	
  }

private static void calculation()
{  int finalmin=Collections.min(goaldiff);
/*for(int i=0;i<l.size();i++)
{ for(int j=0;j<l.get(i).length;j++)
		 System.out.print(l.get(i)[j]);
  		System.out.println();
}*/
for(int i=0;i<goaldiff.size();i++)
	{
	 if(finalmin==goaldiff.get(i))
		{ for(int j=0;j<l.get(i).length;j++)
			{comb+=l.get(i)[j]+"";
			  
			}
		   comb+=",";
		}
	}

 System.out.println(comb);
System.out.println(Collections.min(goaldiff));
}
 public static void main(String[] args) {
	 Equaldivision ed=new Equaldivision();
	 ed.equal();
	 ed.calculation();
	
}

}
