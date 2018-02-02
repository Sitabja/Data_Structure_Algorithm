import java.util.Scanner;


public class Circular {
	public static void main(String[] args) {
	
		        Scanner sc = new Scanner(System.in);

		        int t = sc.nextInt();

		        for (int i = 0; i < t; i++) {
		            int count = 0;
		            long d = sc.nextInt();
		            long n = sc.nextInt();

		            int r = (int)Math.sqrt(d);
		            if (r * r == d) {
		                count = count + 4;
		            }
		            for (int j = r; j > 0; j--) {
		                int n1 = (int)(d - j * j);

		                if (n1 == 0)
		                    continue;
		                int num = (int)Math.sqrt(n1);

		                if (n1 == num * num) {
		                    if (num != j)
		                        count = count + 8;
		                    else
		                        count = count + 4;

		                    break;
		                }

		            }

		            if (n >= count)
		                System.out.println("possible");
		            else
		                System.out.println("impossible");

		        }


	}

}

