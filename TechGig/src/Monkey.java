
public class Monkey {
	public static void main(String[] args) {
		int[] a = {10,2,3,4};
		int n = a.length;
		System.out.println(maxDistance(a,n));
		
	}

	private static int maxDistance(int[] input1, int input2) {
		int overallMax = Integer.MIN_VALUE;
		for(int i = 0 ; i < input2 ; i++){
			for(int j = i+1 ; j < input2 ; j++){
				int distClockWise = input1[i]+input1[j]+(j-i);
				int distAntiClockWise = input1[i]+input1[j]+(input2-j+i);
				int mindist = distClockWise < distAntiClockWise ? distClockWise : distAntiClockWise;
				if(mindist > overallMax){
					overallMax = mindist;
				}
			}
		}
		return overallMax;
		
	}
}
