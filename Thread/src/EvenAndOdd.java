
class MyThread extends Thread{
	boolean isEven;
	Printer printer ;
	public MyThread(Printer printer,String string,boolean isEven) {
		super(string);
		this.isEven = isEven;
		this.printer = printer;
	}

	public void run(){
		
	if(isEven){
		for(int i = 0 ; i < 11 ; i += 2){
			printer.printEven(i,this.getName());
		}
	} else {
		for(int i = 1 ; i < 11 ; i += 2){
			printer.printOdd(i,this.getName());
		}
	}
}
	
}
class Printer {
	boolean isEven = false;
	synchronized public void printOdd(int i,String name) {
		while(isEven == false){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println(name+"   "+i);
			isEven = false;
			notifyAll();
	}

	synchronized public void printEven(int i,String name) {
		while(isEven == true){
			try {
				wait();
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		System.out.println(name +"   "+i);
		isEven = true;
		notifyAll();	
	}

}
public class EvenAndOdd {
public static void main(String[] args) {
	Printer printer = new Printer();
	MyThread t1 = new MyThread(printer,"Thread Odd",false);
	MyThread t2 = new MyThread(printer,"Thread Even",true);
	System.out.println(t1.getName());
	t1.start();
	System.out.println(t2.getName());
	t2.start();
}
}
