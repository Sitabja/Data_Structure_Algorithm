package ANSWERS;

public class B4 {
	public static void main(String[] args) {
		System.out.println(difference(5,3));
	}

	private static int difference(int a, int b) {
		if(a > b){
			return a-b;
		} else{
			return b-a;
		}
		
	}
}
