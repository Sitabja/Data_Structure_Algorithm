package coreJava;

public class SequenceOfExecution {
	public static void main(String[] args) {
		System.out.println("inside main 1");
		ParentClass p;
		System.out.println("inside main 2");
		p = new ChildClass();
		ChildClass c = (ChildClass)p;
		//ParentClass p2 = new ChildClass();
	}
	
}

class ParentClass{
	static{
		System.out.println("parent static");
	}
	{
		System.out.println("parent non static");
	}
	public ParentClass(){
		System.out.println("parent constructor");
	}
}
class ChildClass extends ParentClass{
	static{
		System.out.println("Child static");
	}
	{
		System.out.println("Child non static");
	}
	public ChildClass(){
		System.out.println("Child constructor");
	}
}
