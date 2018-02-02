
public class LinkedListOperation {
	Node head = null;
	public Node revPairWise(Node head){
		if(head == null){
			return head;
		}
		Node temp = head;
		head = head.getNext();
		Node prev = null;
		while(temp.getNext()!= null && temp.getNext().getNext() != null){	
			Node temp2 = temp.getNext().getNext();
			if(prev != null){
				prev.setNext(temp.getNext());
			}
			temp.getNext().setNext(temp);
			temp.setNext(temp2);
			prev = temp;
			temp = temp.getNext();
			new DisplayList().display(head);
			System.out.println(prev.getData()+""+temp.getData());
			
		}
		return head;
		
	}
	
	public Node rev(Node head){
		if(head == null || head.getNext() == null){
			return head;
		}
		Node prev = head;
		Node curr = head.getNext();
		while(curr != null){
			Node temp = curr;
			curr.setNext(prev);
			prev = temp;
			curr = temp.getNext();
			
			}
		return head;
	}
	
	public Node revRecur(Node curr){
		if(curr == null || curr.getNext() == null){
			this.head = curr;
			return curr;
		}
		revRecur(curr.getNext());
		curr.getNext().setNext(curr);
		curr.setNext(null);
		return head;
		
	}
	public Node addLinkedList(Node head1, Node head2){
		Node curr1 = head1;
		Node curr2 = head2;
		int sum = 0;
		int carry = 0;
		Node resultHead = null;
		Node temp = null;
		while(curr1 != null && curr2 != null){
			sum = curr1.getData()+curr2.getData()+ carry;
			Node n = new Node();
			n.setData(sum%10);
			if(resultHead ==  null){	
				temp = n;
				resultHead = temp;
			} else {
				temp.setNext(n);
				temp = temp.getNext();
			}
			curr1 = curr1.getNext();
			curr2 = curr2.getNext();
			carry = sum / 10;
		}
		while(curr1 != null){
		 sum = curr1.getData()+ carry;
		 Node n = new Node();
		 n.setData(sum % 10);
		 temp.setNext(n);
		 temp = temp.getNext();
		 curr1 = curr1.getNext();
		}
		while(curr2 != null){
			 sum = curr2.getData()+ carry;
			 Node n = new Node();
			 n.setData(sum % 10);
			 temp.setNext(n);
			 temp = temp.getNext();
			 curr2 = curr2.getNext();
			}
		return resultHead;
	}
	
	public Node rotateLinkedList(Node head,int k){
		int count = 0;
		Node temp = head;
		Node temp2 = head;
		while (temp.getNext() != null){
			while(count < k){
				temp = temp.getNext();
				count ++;
			}
			temp = temp.getNext();
			temp2 = temp2.getNext();
		}
		Node temp3 = temp2.getNext();
	    temp2.setNext(null);
	    temp.setNext(head);
	    head = temp3;
	    return head;
	}
}

