package comp20010_practical2;

import java.util.Random;

public class LinkedListTester {
	private static Random random = new Random(20010);

	public static void test1() {
		// create your own LinkedList
		SinglyLinkedList ll = new SinglyLinkedList();
		//DoublyLinkedList ll = new DoublyLinkedList();

		// lets create an array of String's
		// and fill our list with a random sample of the data
		String[] data = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };

		for (int i = 0; i < 50; ++i) {
			ll.addLast(data[random.nextInt(data.length)]);
		}

		// now, call each function in the API, choosing at random 
		int N = 100;
		String[] procs = { "addFirst", "addLast", "removeFirst", "removeLast", "addBefore", "remove" };

		for (int i = 0; i < N; ++i) {
			String s = data[random.nextInt(data.length)];
			switch (procs[random.nextInt(procs.length)]) {
			case "addFirst":
				ll.addFirst(s);
				break;
			case "addLast":
				ll.addLast(s);
				break;
			case "removeFirst":
				if (!ll.isEmpty()) {
					ll.removeFirst();
				}
				break;
			case "removeLast":
				if (!ll.isEmpty()) {
					ll.removeLast();
				}
				break;
			case "remove":
				ll.remove(s);
				break;
			case "addBefore":
				// if you have a positional add() then do this:
				// ll.add(random.nextInt(ll.size()), s);

				// if you have a key-based add do this
				// String key = data[random.nextInt(data.length)];
				// ll.addBefore(key, s);
				break;
			default:
				System.out.println("unknown");
				break;
			}
		}

		// print out the size of the list and the elements...
		System.out.println("size(ll): " + ll.size());
		for (String s : ll) {
			System.out.println("ll -> " + s);
		}
	}

	public static void main(String[] args) {
		test1();
	}
}
