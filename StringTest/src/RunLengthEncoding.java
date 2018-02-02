import java.util.Scanner;


public class RunLengthEncoding {
	public static void main(String[] args) {
		System.out.println(encodeString(new Scanner(System.in).next()));
	}

	private static String encodeString(String s) {
		String output = "";
		int count = 1;
		for(int i=0 ; i < s.length() ; i++){
			if(output.length()>0 && output.charAt(output.length() - 1) == s.charAt(i)){
				count++;
			} else {
				if(count > 1){
					output += count;
				}
				output += s.charAt(i);
				count = 1;
			}	
		}
		output += count;
		
		return output;
		
		
	}
}
