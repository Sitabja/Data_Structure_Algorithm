
public class DisplayList extends Node {
	

	public void display(Node head)
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.getData()+" ---> ");
			temp =temp.getNext();
			
		}
		System.out.println("null");
		
	}

}
