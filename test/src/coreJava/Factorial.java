package coreJava;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(getFact(3));
	}

	private static int getFact(int i) {
		if(i==0 || i==1){
			return 1;
		}
		return i*getFact(i-1);
	}
}
