
public class MergeConsicutive {
	
	public Node merge( Node head1 , Node head2) {
		
		if(head1 == null && head2 == null)
			return null;
		if(head1 == null && head2 != null)
			return head2;
		if( head1 != null && head2 == null)
			return head1;
		else {
			Node temp = head1;
			//Node temp2 = head2;
			
			while( temp.getNext() != null && head2 != null) {
				Node temp1 = temp.getNext();
				//Node temp3 = new Node();
				/*temp3.setData(temp2.getData());
				temp3.setNext(temp2.getNext());
				*/
				
				temp.setNext(head2);
				head2 = head2.getNext();
				temp = temp.getNext();
				temp.setNext(temp1);
				temp = temp.getNext();
				
				
			}
			
			if( temp.getNext() == null && head2 != null )
				temp.setNext(head2);
				
			return head1;
			
		}
	}
	

}
