
public class Insertion extends Node{
		
	

	public Node Insert(Node head,Node nodeToInsert,int position)
	{   
		if(head == null)
			return nodeToInsert;
		else
		{
			if ( position == 0 )
			{
				nodeToInsert.setNext(head);
				head = nodeToInsert;
			}
			else
			{
				Node temp = head ;
				int count = 1;
				while( temp.getNext() != null && count < position )
				{
					temp = temp.getNext();
					count++;
				}
				if( temp.getNext() == null && count != position - 1 )
					{ 
					 	System.out.println("Invalid position");
					 	return head;
					}
				else
				{
					nodeToInsert.setNext(temp.getNext());
					temp.setNext(nodeToInsert);
					
					
				}
			}
			
		}
		return head;
		
		
	}
				
	

}
