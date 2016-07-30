/**
 * The implementation of a doubly chained circular Linked List.
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 * @param <E> generic data type for an element
 */

public class LinkedList<E> {

	//the current size of the linked list
	private int size;
	//the first node in the linked list
	private Node<E> head;
	//the last node in the linked list
	private Node<E> tail;

	/**
	 * Constructor to create a Linked List
	 */
	public LinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * The size of the Linked List
	 * @return size the size of the linked list
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Whether the Linked List has any elements currently in it
	 * @return true if there are no elements in the Linked List
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds a value to the end of the Linked List
	 * @param data the value to be added
	 */
	public void add(E data) {
		Node<E> node = new Node<E>(data, null, tail);
		if(isEmpty()) {
			node.setNext(node);
			node.setPrev(node);
			head = node;
			tail = head;
		}
		else {
			node.setPrev(tail);
			tail.setNext(node);
			head.setPrev(node);
			node.setNext(head);
			tail = node;
		}
		size++;
	}

	/**
	 * Adds a value at a specific position of the Linked List
	 * @param data the value to be added
	 * @param pos the position to be added to
	 */
	public void addAtPos(E data, int pos) {
		if(pos > size) {
			System.out.println("The list has only "+ size + " elements." );
		}
		pos--;
		Node<E> node = new Node<E>(data, null, null);
		if(isEmpty()) {
			node.setNext(node);
			node.setPrev(node);
			head = node;
			tail = node;
		}
		else {
			Node<E> curr = new Node<E>(data, null, null);
			curr = head;
			for(int i = 2; i <= pos; i++) {
				curr = curr.getNext();
			}
			node.setPrev(curr);
			node.setNext(curr.getNext());
			curr.getNext().setPrev(node);
			curr.setNext(node);
		}
		size++;
	}

	/**
	 * Deletes and returns the last value from the Linked List
	 * @return the data at the last position of the Linked List
	 */
	public E remove() {
		if(isEmpty()) {
			System.out.println("The Linked List is empty.");
			return null;
		}
		else {
			tail.getPrev().setNext(null);
			size--;
			return tail.getData();
		}
	}

	/**
	 * Deletes and returns a valye at a specific position from the Linked List
	 * @param pos the specific position to remove value from
	 * @return the data at the specified position of the Linked List
	 */
	public E removeAtPos(int pos) {
		if(pos > size) {
			System.out.println("The list has only "+ size + " elements." );
		}
		pos--;
		if(isEmpty()) {
			System.out.println("The Linked List is empty.");
			return null;
		}
		else {
			Node<E> curr = new Node<E>();
			curr = head;
			for(int i = 2; i <= pos; i++) {
				curr = curr.getNext();
			}
			Node<E> nodeToGet = curr.getNext();
			curr.getNext().getNext().setPrev(curr);
			curr.setNext(curr.getNext().getNext());
			size--;
			return nodeToGet.getData();
		}
	}

	public void display() {
		System.out.print("\nCircular Doubly Linked List = ");
		Node<E> ptr = head;
		if (size == 0) 
		{
			System.out.print("empty\n");
			return;
		}
		if (head.getNext() == head) 
		{
			System.out.print(head.getData()+ " <-> "+ptr.getData()+ "\n");
			return;
		}
		System.out.print(head.getData()+ " <-> ");
		ptr = head.getNext();
		while (ptr.getNext() != head) 
		{
			System.out.print(ptr.getData()+ " <-> ");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getData()+ " <-> ");
		ptr = ptr.getNext();
		System.out.print(ptr.getData()+ "\n");
	}

	/**
	 * Print the Linked List on the screen

		public void display() {
			if(isEmpty()) {
				System.out.println("The Linked List is empty.");
			}
			else {
				Node<E> curr = head;
				while(curr != null) {
					System.out.print(curr.getData() + ", ");
					curr = curr.getNext();
				}
			}
		}
	 */
}