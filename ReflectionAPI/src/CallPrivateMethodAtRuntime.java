import java.lang.reflect.Method;
import java.util.Scanner;


public class CallPrivateMethodAtRuntime {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		Class c = Class.forName(sc.next());
		
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("privateMethod",new Class[]{String.class,int [].class});
		         
		 m.setAccessible(true);
		 m.invoke(o, new Object[]{"Hello",new int[]{69}});
		
		
	}

}
