package coreJava;

public class RecursionTest {
	public static void main(String[] args) {
		//System.out.println(powers(5,3));
		//System.out.println(powersEfficient(5,3));
		int []a = {1,3,2,4,5,6,2,7,8,1,9,3};
		//System.out.println(binarySum(a,0,12));
		String s ="abc";
		System.out.println(isPalindrome(s,0,s.length()-1));
		permute(s,0,s.length()-1);
	}

	private static void permute(String s, int l, int r) {
		if(l==r){
			System.out.println(s);
		} else {
			for(int i=l ;i <= r;i++){
				s = swap(s,l,i);
				permute(s,l+1,r);
				s = swap(s,l,i);
			}
		}
		
	}

	private static String swap(String s, int l, int r) {
		char[] charArray = s.toCharArray();
		charArray[r] = (char) ((charArray[l]+charArray[r])-(charArray[l]=charArray[r]));
		
		return String.valueOf(charArray);
	}

	private static boolean isPalindrome(String s,int i ,int j) {
		if(j<=i){
			return true;
		} 
		if(s.charAt(i) != s.charAt(j)){
			return false;
		}
		return isPalindrome(s, i+1, j-1);
		
		
		
	}

	private static int binarySum(int[] a, int i, int j) {
		if(j==1){
			return a[i];
		}
		return binarySum(a, i, j/2)+binarySum(a, i + j/2, j/2);
	}

	private static int powersEfficient(int x, int n) {
		if(n==0){
			return 1;
		}
		if(n%2 != 0){
			int y = powersEfficient(x, (n-1)/2);
			return x * y * y;
		} else {
			int y = powersEfficient(x, n/2);
			return y*y;
		}
		
	}

	private static int powers(int x, int n) {
		if(n==0){
			return 1;
		}
		return x*powers(x,n-1);
		
	}
	
}
