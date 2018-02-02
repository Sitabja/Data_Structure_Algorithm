package ANSWERS;

public class C6 {
	public static void main(String[] args) {
		int arraySize = 1000000;
		for (int j=1; j <=10 ; j++ ){
			int [] a = new int[arraySize*j];
			int value[] = {1000000,2000000,500000,10000000,20000000};
			double duration = 0.0;
			for(int i = 0 ; i < a.length ; i++){
				int random = (int)(Math.random()*5);
				a[i] = value[random];
				
			}
			for(int k = 1 ; k <=5 ; k++){
				 long start = System.currentTimeMillis();
				 minValueIndex(a,a.length);
				 long end = System.currentTimeMillis();
				 duration += end -start; 
			}
			System.out.println(a.length+" "+duration / 5);
		}
	}

	private static int minValueIndex(int[] a, int n) {
		int minValueIndex = 0;
		for(int k = 1 ; k <= n-1 ; k++){
			if(a[minValueIndex] > a[k]){
				minValueIndex = k;
			}
		}
		return minValueIndex;
	}

}
