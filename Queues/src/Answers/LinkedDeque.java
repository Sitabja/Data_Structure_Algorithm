package Answers;

public class LinkedDeque<E> implements Deque<E> {
  private DLNode<E> header, trailer;  
  private int size;    // number of elements

  public LinkedDeque() {  // initialize an empty deque
    header = new DLNode<E>();
    trailer = new DLNode<E>();
    header.setNext(trailer);  // make header point to trailer
    trailer.setPrev(header);  // make trailer point to header
    size = 0;
  }

/** 
 * Return the size of the deque, that is the number of elements it has. 
 * @return  Number of elements in the deque
 */
  @Override
  public int size() {   
    return size;
  } 
/** 
 * This function returns true if and only if the deque is empty 
 * @return  true if the deque is empty, false otherwise
 */
  @Override
  public boolean isEmpty() {    
    return size == 0;
  }

/** 
 * Inspect the first element without modifying the deque.
 * @return The first element in the sequence
 */    
  @Override
  public E getFirst() throws EmptyDequeException {  
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return header.getNext().getElement();
  }
 
  public E getLast() throws EmptyDequeException { 
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return trailer.getPrev().getElement();
  }
  
  public void addFirst(E o) {  
    DLNode<E> second = header.getNext();
    DLNode<E> first = new DLNode<E>(o, header, second);
    second.setPrev(first);
    header.setNext(first);
    size++;
  }

  @Override
  public void addLast(E o) {  
    DLNode<E> secondtolast = trailer.getPrev();
    DLNode<E> last = new DLNode<E>(o, secondtolast, trailer);
    secondtolast.setNext(last);
    trailer.setPrev(last);
    size++;
  }
  @Override
  public E removeFirst() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> first = header.getNext();
    E o = first.getElement();
    DLNode<E> second = first.getNext();
    header.setNext(second);
    second.setPrev(header);
    size--;
    return o;
   }

 @Override
  public E removeLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> last = trailer.getPrev();
    E o = last.getElement();
    DLNode<E> secondtolast = last.getPrev();
    trailer.setPrev(secondtolast);
    secondtolast.setNext(trailer);
    size--; 
    return o;
  }
 @Override
 public String toString(){
	 String output = "";
	 output += this.size()+"\t"; 
	 DLNode<E> temp = header.getNext();
	 while(!temp.equals(trailer)){
		 output += temp.getElement()+" ";
		 temp = temp.getNext();
	 }
	 return output; 
 }
}

