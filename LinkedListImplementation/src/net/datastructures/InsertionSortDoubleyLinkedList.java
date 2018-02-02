package net.datastructures;

public class InsertionSortDoubleyLinkedList {
	public static <E> void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		for(int i = 0 ;i < 10 ;i++){
			dll.addLast((int)Math.random()*10);
		}
		sort(dll);
	}

	private static void sort(DoublyLinkedList<Integer> l) {
		if(l.size() <= 1){
			return;
		}
		int i = l.first();
		
	}
}
