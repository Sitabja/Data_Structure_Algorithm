import java.lang.reflect.*;
import java.util.Scanner;


public class javapTool {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Class c = Class.forName(sc.next());
		
		System.out.println("Fields.......");
		Field[] f = c.getDeclaredFields();
		for(int i = 0 ; i < f.length ; i ++)
			System.out.println(f[i]);
		
		System.out.println("Constructors......");
		Constructor con[] = c.getDeclaredConstructors();
		for(int i = 0 ; i < con.length ; i ++)
			System.out.println(con[i]);
		
		System.out.println("Methods........");
		Method m[] = c.getDeclaredMethods();
		for(int i = 0 ; i < m.length ; i ++)
			System.out.println(m[i]);
	}

}
