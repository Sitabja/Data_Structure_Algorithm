
public class Cisco {
	public static void main(String[] args) {
		String[] input1 = {"empty","D1","D2","D3","D4","D5","D6","empty","C1","empty","C2","C3","D7","D8"
				,"empty","empty","empty","empty","empty","empty","empty","empty","empty","empty",
				"C4","empty","C5","C6","empty","empty","empty","empty",};
		int input2 = input1.length;
		maxMediators(input1, input2);
		
	}
	 public static int maxMediators(String[] input1,int input2)
	  {
		   int[] height = new int[input2];
		 	recur(input1,1,height);
		 	for(int i = 0 ; i < input2 ;i++){
		 		System.out.print(i+" \t");
		 	}
		 	System.out.println();
		 	for(int i = 0 ; i < input2 ;i++){
		 		System.out.print(input1[i]+" \t");
		 	}
		 	System.out.println();
		 	for(int i = 0 ; i < input2 ;i++){
		 		System.out.print(height[i]+" \t");
		 	}
		 	System.out.println("0\t");
		 	int sum = 0;
		 	int max = 0 ;
		 	for(int i = 1 ; i < input2/2 ;i++){
		 		sum = height[2*i] + height[2*1+1];
		 		if( sum > max){
		 			max = sum;
		 		}
		 		System.out.print(sum+1+" \t");
		 	}
		 	return max+1;
	       
	   }
	private static int recur(String[] input1, int index, int[] height) {
		if(input1[index].charAt(0)== 'C' || input1[index].charAt(0)== 'c'){
			return 0;
		}
		if(input1[index].equalsIgnoreCase("Empty")){
			return 0;
		} 
		int h = Math.max(recur(input1,2*index,height), recur(input1,2*index+1,height));
		height[index] = h+1;
		return height[index];
		
	}
}



