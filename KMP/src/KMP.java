
public class KMP {
	public static void main(String[] args) {
		search("ababcabcabbbcbbcb","abcabbbcb");
	}
	
	public static void search(String text, String pattern){
		int i = 0 , j = 0 ;
		int arr[] = preprocess(pattern);
		for(int m = 0; m < pattern.length() ; m++)
		{
			System.out.print(pattern.charAt(m)+" ");
		}
		System.out.println();
		for(int k = 0 ; k < arr.length ; k++)
			{ 
				System.out.print(arr[k]+" ");
			}
		System.out.println();
		while( i < text.length())
			if(text.charAt(i) == pattern.charAt(j))
				{if( j == pattern.length() - 1)
					{ System.out.println("match found at "+(i-j));
					   return;
					}
				  i++;
				  j++;
				}
				else if( j > 0)
				{
					j = arr[j-1]; 
				}
				else
					i++;
		
	}
	
	public static int[] preprocess(String pattern){
		int arr[] = new int[pattern.length()];
		int i = 1;
		int j = 0;
		
		while(i < pattern.length()){
		if(pattern.charAt(i) == pattern.charAt(j))
		{
			arr[i] = j+1;
			i++;
			j++;
		}
		else if(j > 0)
			j = arr[j-1];
		else
		{
			arr[i] = 0;
			i++;
		}
		}	
	  return arr;
		
	}
}
