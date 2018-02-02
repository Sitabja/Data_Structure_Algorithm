package coreJava;

class Parent {
	public void test(int a,int b){
		System.out.println("inside parent int");
	}
	public static void test(long a, long b){
		System.out.println("inside parent long");
	}
//	public void test(float a, float b){
//		System.out.println("inside float");
//	}
	public void test(double a , double b){
		System.out.println("inside parent double");
	}
	public void parentMethod(){
		System.out.println("inside parent method");
	}
}
class Child extends Parent{
	public static void test(long a,long b){
		System.out.println("inside Child int");
	}
	public void childMethod(){
		System.out.println("inside child method");
	}
}
public class Inheritence {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = (Child) p;
		//p.test(4, 5); 
		c.parentMethod();
		c.childMethod();
	}
}
