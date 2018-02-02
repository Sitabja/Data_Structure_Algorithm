
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Node head1 = null;
		Node head2 = null;
	
		Insertion in = new Insertion();
	   
		for(int i = 1 ; i < 5 ; i++){
			Node n = new Node();
			n.setData(i);
			 head1 = in.Insert(head1, n, 0);
		}
		
		for(int i = 4 ; i < 10 ; i++){
			Node n = new Node();
			n.setData(i);
			 head2 = in.Insert(head2, n, 0);
		}
		
		DisplayList d = new DisplayList();
		d.display(head1);
		
		d.display(head2);
		
//		MergeConsicutive m = new MergeConsicutive();
//		Node head = m.merge(head1, head2);
//		d.display(head);
		
		LinkedListOperation r = new LinkedListOperation();
		d.display(r.rotateLinkedList(head1,2));
	}

}
