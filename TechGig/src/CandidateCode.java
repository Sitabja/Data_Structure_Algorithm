import java.awt.Point;


public class CandidateCode {
	public static void main(String[] args) {
		
	}
	
	 public static String[] nearest_shoot_point(int[] input1,int[] input2,int[] input3,String[] input4)
	    {
			int m = input1[0];
			int n = input1[1];
			
			int srow = input2[0];
			int scol = input2[1];
			
			int trow = input3[0];
			int tcol = input3[1];
			
			int a[][] = new int[m][n];
			
			for(int i = 0 ; i < input4.length ; i ++)
			{
				String s[] = input4[0].split("#");
				int j = Integer.parseInt(s[0]);
				int k = Integer.parseInt(s[1]);
				
				a[j][k] = -1 ;
				
			}
			
	        
	    }


		
	}

}
