package ANSWERS;

public class C4 {
	public static void main(String[] args) {
		int a = 5000000;
		int b = 3000000;
		double duration = 0.0;
		for (int i=0; i<5; i++) {
		 long start = System.currentTimeMillis();
		 difference(a,b);
		 long end = System.currentTimeMillis();
		 duration += end-start;
		}
		System.out.println("Runtime "+duration/5);

	}

	private static int difference(int a, int b) {
		if(a > b){
			return a-b;
		} else{
			return b-a;
		}
		
	}
}
