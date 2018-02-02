
public class Flip {
 public static void main(String[] args) {
	/*int bin[] = new int[32];
	
	String s = "";
	
	bin = getBinaryFormat(1);
	
	for(int i = bin.length - 1 ; i > 0 ; i--)
	{	 if(bin[i] == 0)
			 s += "1" ;
		else
			s += "0" ;
		
	}
	
	long l = Long.parseLong(s);
	
	
	
	System.out.println(getDecimalFromBinary(l));
	
	
	 
	
}
 

		private static long getDecimalFromBinary(long binary){
			
			long decimal = 0l;
			long power = 0l;
			while(true){
				if(binary == 0){
					break;
				} else {
					long tmp = binary%10;
					decimal += tmp*Math.pow(2, power);
					binary = binary/10;
					power++;
				}
			}
			return decimal;
		}
		
		private static int[] getBinaryFormat(int number)
		{ 
			int binary[] = new int[32]; 
		
			int index = 0; 
		
			while(number > 0)
			{ 
				binary[index++] = number%2;
			
				number = number/2; 
			} 
		
			return binary ;
		
			}
	*/	
	 long in = 2147483647l;
	 System.out.println(4294967295l - in );
	 
 }
   
 

} 