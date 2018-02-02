package Test;
 class A{
	public void print(){
		System.out.println("Inside A");
	}
	public void abc(){
		System.out.println("Inside abc");
	}
}
 
 class B extends A {
	 public void print(){
			System.out.println("Inside B");
		}
	 public void xyz(){
			System.out.println("Inside xyz");
		}
 } 
public class DynamicBindingTest {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b1 = new B();
		B b2 = (B)a2;
		a1.print();
		
		a2.print();
		a2.abc();
		
		b1.print();
		b2.print();
		b2.xyz();
		
	}

}
