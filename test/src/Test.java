import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Map<Integer,ArrayList> cow1=new HashMap<Integer,ArrayList>();
		Map<Integer,ArrayList> cow2=new HashMap<Integer,ArrayList>();
		Map<Integer,ArrayList> cow3=new HashMap<Integer,ArrayList>();
		Map<Integer,ArrayList> bull1=new HashMap<Integer,ArrayList>();
		Map<Integer,ArrayList> bull2=new HashMap<Integer,ArrayList>();
		Map<Integer,ArrayList> bull3=new HashMap<Integer,ArrayList>();
	    Map<String,Boolean[]> prob=new HashMap<String,Boolean[]>();
		String sWord = "";
		String[] done={"?","?","?","?"};
		while(!sWord.equals("done"))
		{ Scanner sc=new Scanner(System.in);
		
		 sWord=sc.next();
		int cows=sc.nextInt();
		int bulls=sc.nextInt();
	
		ArrayList<String> value=new ArrayList<String>();
		for(int i=0;i<sWord.length();i++)
			{	value.add(""+sWord.charAt(i));
			
			}
		if(cows==1)
		  {
		  cow1.put(cow1.size()+1,value);
		  }
		else if(cows==2)
			 cow2.put(cow2.size()+1,value);
		else if(cows==3)
			 cow3.put(cow3.size()+1,value);
		else if(bulls==1)
		 {
			 bull1.put(bull1.size()+1,value);
			 for(int i=1;i<bull3.size();i++)
				 for(int j=0;j<4;j++)
				 {
					if(! bull1.get(i).get(j).toString().equals(done[j]))
					{
						if(done[j].equals("?") && done.toString().indexOf("?")==done.toString().lastIndexOf("?"))
						{
							done[j]=bull1.get(i).get(j).toString();
						}
					}
				 }
		 }
		else if(bulls==2)
		    { 
			int count=0;
			
			
		    for(int i=0;i<4;i++)
		    {
		    	if(done[i]=="?")
		    	{
		    		count++;
		    	}
		    }
		    for(int i=1;i<=bull2.size();i++)
				 for(int j=0;j<4;j++)
				 { 
					if(! bull2.get(i).get(j).toString().equals(done[j]))
					{
						if(done[j].equals("?") && count==2)
						{
							done[j]=sWord.charAt(j)+"";
						
						}
					}
				 }	    
			int k = 0;
			int count1=0;
		    int [] pos={-1,-1,-1,-1};
		   int[] pos1={-1,-1,-1,-1};
			for(int m=1;m<=bull2.size();m++)
			{ int count2=0;
				for(int n=0;n<4;n++)
				{ 
					if(bull2.get(m).get(n).toString().equals(sWord.charAt(n)+""))
					{ 
						if(k<=1 )
						{pos[count2]=n;
						
						}
						if( pos[1]==pos1[1] && pos[2]==pos1[2] && pos[3]==pos1[3])
						{count2++;
						
						}
						k++;
					}
				
					
					if(k<=2)
					{
						pos1=pos;
					}
				}	
				if(count2==2)
					{count1++;
					}
				}	
			
			
			/*for(int i=0;i<done.length;i++)
			{
				System.out.println(pos1[i]);
				System.out.println(done[i]);
			}*/
			if(count1==3)
			{
				for(int i=0;i<2;i++)
				{ System.out.println(i);
					if(done[pos1[i]].equals("?"))
					{
						done[pos1[i]]=sWord.charAt(pos1[i])+"";
						
					}
					
				}
			}
			
			bull2.put(bull2.size()+1,value);
  		    }
		else if(bulls==3)
		{  int count=0;
		   int pos=-1;
			 bull3.put(bull3.size()+1,value);
			 for(int i=1;i<bull3.size();i++)
				 for(int j=0;j<4;j++)
				 { System.out.println(bull3.get(i).get(j)+"  "+sWord.charAt(j)+"");
					 if(!bull3.get(i).get(j).toString().equals(sWord.charAt(j)+""))
					 { 
						 pos=j;
						 count++;
					 }
				 }
			 if(count==1)
			 { for(int i=0;i<4;i++)
			    {
				 done[i]=sWord.charAt(i)+"";
			    }
				done[pos]="?"; 
				 
			 }
		}
      if(cows==0 && bulls==0)
      	{    if(!cow1.isEmpty())
    	       for(int j=1;j<=cow1.size();j++)
    	    	 for(int i=0;i<sWord.length();i++)
    	        {
    	          if(cow1.get(j).contains(sWord.charAt(i)+""))
    	          {
    	        	  cow1.get(j).set(i,"");
    	          }
    	        }
      	      if(!cow2.isEmpty())
    	       for(int j=1;j<=cow2.size();j++)
     	    	 for(int i=0;i<sWord.length();i++)
     	        {
     	          if(cow2.get(j).contains(sWord.charAt(i)+""))
     	          {
     	        	  cow2.get(j).set(i,"");
     	          }
     	        }
    	      if(!cow3.isEmpty()) 
    	       for(int j=1;j<=cow3.size();j++)
      	    	 for(int i=0;i<sWord.length();i++)
      	        {
      	          if(cow3.get(j).contains(sWord.charAt(i)+""))
      	          {
      	        	  cow3.get(j).set(i,"");
      	          }
      	        }
    	      if(!bull1.isEmpty())
    	       for(int j=1;j<=bull1.size();j++)
      	    	 for(int i=0;i<sWord.length();i++)
      	        {
      	          if(bull1.get(j).contains(sWord.charAt(i)+""))
      	          {
      	        	  bull1.get(j).set(i,"");
      	          }
      	        }
    	      for(int j=1;j<=bull2.size();j++)
      	    	 for(int i=0;i<sWord.length();i++)
      	        {
      	          if(bull2.get(j).contains(sWord.charAt(i)+""))
      	          {
      	        	  bull2.get(j).set(i,"");
      	          }
      	        }
    	      if(!bull3.isEmpty())
    	      for(int j=1;j<=bull3.size();j++)
     	    	 for(int i=0;i<sWord.length();i++)
     	        { System.out.println(bull3.get(j));
     	          if(bull3.get(j).contains(sWord.charAt(i)+""))
     	          {
     	        	  bull3.get(j).set(i,"");
     	          }
     	        }
     	        
     	    for(int i=1;i<=cow1.size();i++)
     	    {  int count=0;
     	       int pos1 = -1;
     	       String s="";
     	      Boolean[] pos={true,true,true,true};
     	    	for(int j=0;j<4;j++)
     	    	if((cow1.get(i).get(j))!="")
     	    	{   pos1=j;
     	    		s=(String) cow1.get(i).get(j);
     	    		count++;
     	    	}
     	    	if(count==1 && !prob.containsKey(s))
     	    	{  pos[pos1]=false;
     	    		prob.put(s,pos);
     	    	}
     	    }
     	    
     	   for(int i=1;i<=cow2.size();i++)
    	    {  int count=0;
    	       int pos1[] ={-1,-1,-1,-1};
    	       String[] s={"","",","};
    	       int k=0;
    	      Boolean[] pos={true,true,true,true};
    	    	for(int j=0;j<4;j++)
    	    	if((cow2.get(i).get(j))!="")
    	    	{   pos1[k]=j;
    	    		s[k]=(String) cow2.get(i).get(j);
    	    		count++;
    	    		k++;
    	    	}
    	    	if(count==2 && !prob.containsKey(s))
    	    	{  pos[pos1[0]]=false;
    	    		prob.put(s[0],pos);
    	    		pos[pos1[1]]=false;
    	    		prob.put(s[1],pos);
    	    	}
    	    }
     	   
     	  for(int i=1;i<=cow3.size();i++)
  	    {  int count=0;
  	       int pos1[] ={-1,-1,-1,-1};
  	       String[] s={"","",","};
  	       int k=0;
  	      Boolean[] pos={true,true,true,true};
  	    	for(int j=0;j<4;j++)
  	    	if((cow3.get(i).get(j))!="")
  	    	{   pos1[k]=j;
  	    		s[k]=(String) cow3.get(i).get(j);
  	    		count++;
  	    		k++;
  	    	}
  	    	if(count==3 && !prob.containsKey(s))
  	    	{  pos[pos1[0]]=false;
  	    		prob.put(s[0],pos);
  	    		pos[pos1[1]]=false;
  	    		prob.put(s[1],pos);
  	    		pos[pos1[2]]=false;
  	    		prob.put(s[2],pos);
  	    	}
  	    }
     	  
     	  
   	   
     	  for(int i=1;i<=bull1.size();i++)
  	    {  int count=0;
  	       int pos1[] ={-1,-1,-1,-1};
  	       String[] s={"","",","};
  	       int k=0;
  	     
  	    	for(int j=0;j<4;j++)
  	    	if((bull1.get(i).get(j))!="")
  	    	{   pos1[k]=j;
  	    		s[k]=(String) bull1.get(i).get(j);
  	    		count++;
  	    		k++;
  	    	}
  	    	if(count==1 && !prob.containsKey(s))
  	    	{ done[pos1[0]]=s[0];
  	    	}
  	    }
     	  
     	 for(int i=1;i<=bull2.size();i++)
   	    {  int count=0;
   	       int pos1[] ={-1,-1,-1,-1};
   	       String[] s={"","",","};
   	       int k=0;
   	     
   	    	for(int j=0;j<4;j++)
   	    	if((bull2.get(i).get(j))!="")
   	    	{   pos1[k]=j;
   	    		s[k]=(String) bull2.get(i).get(j);
   	    		count++;
   	    		k++;
   	    	}
   	    	if(count==2 && !prob.containsKey(s))
   	    	{ done[pos1[0]]=s[0];
   	    	  done[pos1[1]]=s[1];
   	    	}
   	    }
     	  
     	 for(int i=1;i<=bull3.size();i++)
   	    {  int count=0;
   	       int pos1[] ={-1,-1,-1,-1};
   	       String[] s={"","","",""};
   	       int k=0;
   	     
   	    	for(int j=0;j<4;j++)
   	    	if((bull3.get(i).get(j))!="")
   	    	{   pos1[k]=j;
   	    	  // System.out.println( bull3.get(i).get(j));
   	    		s[k]=(String) bull3.get(i).get(j);
   	    		count++;
   	    		k++;
   	    	}
   	    	if(count==3 && !prob.containsKey(s))
   	    	{ done[pos1[0]]=s[0];
   	    	  done[pos1[1]]=s[1];
   	    	  done[pos1[2]]=s[2];
   	    	}
   	    }
      	}
      for(int i=0;i<done.length;i++)
       System.out.print(done[i]);
      System.out.println();
      System.out.println("need another one");
      System.out.println();
		}	
	}
}

