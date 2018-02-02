
public class Mytest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="3 4 4 5";
		String arr[] = input.split(" ");
		int l = Integer.parseInt(arr[0]);
		
		int p[]= new int[arr.length-1];
		for(int i = 1; i<arr.length; i++)
		{
			p[i-1] = Integer.parseInt(arr[i]);
		}
		
		String output = "";
		
		for(int i = 0, num =1;i<p.length ; i++,num++)
		{
			if(i==0)
			{
				for(int j = 1; j<=p[i];j++)
					output += num + " ";
			}
			else
			{
				if(p[i]>p[i-1])
				{
					for(int j = p[i-1]; j<p[i];j++)
						output += num + " ";
				}
			}
		}
		System.out.println(output);
	}

}
