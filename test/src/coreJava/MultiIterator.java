package coreJava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;    

public class MultiIterator<E> implements Iterator {

    List<Iterator<E>> iterators = new LinkedList();
    Iterator<E> current = null;

    public MultiIterator(Iterator<Iterator<E>> iterator) {
        // copy the iterators into a list
        while (iterator.hasNext()) {
            iterators.add(iterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (iterators.isEmpty() && (current == null || !current.hasNext())) {
            return false;
        }

        if (current == null) {
            current = iterators.remove(0);
        }

        while (!current.hasNext() && !iterators.isEmpty()) {
            current = iterators.remove(0);
        }

        if (current.hasNext()) {
            result = true;
        }
        return result;
    }

    @Override
    public E next() {
        if (current == null) {
            try {
                current = iterators.remove(0);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
        E result = null;
        if(current.hasNext())
        	result = current.next();
        else
        	current = iterators.remove(0);
        return result;
    }

    // test
    public static void main(String[] args) {
        List<Integer> a = new LinkedList();
        a.add(1);
        a.add(7);
        a.add(13);
        a.add(17);
        List<Integer> b = new LinkedList();
        b.add(2);
        b.add(8);
        b.add(14);
        b.add(18);
        List<Integer> c = new LinkedList();
        c.add(3);
        c.add(9);
        List<Integer> d = new LinkedList();
        d.add(4);
        d.add(10);
        d.add(15);
        List<Integer> e = new LinkedList();
        e.add(5);
        e.add(11);
        List<Integer> f = new LinkedList();
        f.add(6);
        f.add(12);
        f.add(16);
        f.add(19);
        List<Iterator<Integer>> iterators = new LinkedList();
        iterators.add(a.iterator());
        iterators.add(b.iterator());
        iterators.add(c.iterator());
        iterators.add(d.iterator());
        iterators.add(e.iterator());
        iterators.add(f.iterator());
        MultiIterator<Integer> it = new MultiIterator(iterators.iterator());
        while (it.hasNext()) {
        	int n = it.next();
        	//System.out.println("\nhere" +n);
            System.out.print(n + ","); // prints: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
        }
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}