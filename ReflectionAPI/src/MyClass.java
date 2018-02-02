
public class MyClass {
	public int a;
	private int b;
	
	public MyClass(){}
	
	private MyClass(String s){}
	
	public void fun(){}
	
	public void fun(int a){}
	
	private void privateMethod(String s, int... a){
		System.out.println("Sandip");
		
		System.out.println(s);
		
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
