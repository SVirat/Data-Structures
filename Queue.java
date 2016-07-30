/**
 * The implementation of a Queue using Linked Lists.
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 * @param <E> generic data type for an element
 */

public class Queue<E> {

	//the current size of the Queue
	private int size;
	//the first element of the Queue
	private Node<E> front;
	//the last element of the Queue
	private Node<E> back;
	
	/**
	 * Constructor for creating the Queue
	 */
	public Queue() {
		this.size = 0;
		this.front = null;
		this.back = null;
	}
	
	/**
	 * The number of elements in the Queue
	 * @return the current size of the Queue
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Whether the Queue currently has any elements in it
	 * @return true if there are no elements in the Queue
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param data the element to be added at the end of the Queue
	 */
	public void enqueue(E data) {
		Node<E> node = new Node<E>(data, null, null);
		if(isEmpty()) {
			front = node;
			back = node;
		}
		else {
			back.setNext(node);
			back = back.getNext();
		}
		size++;
	}
	
	/**
	 * Removes and returns the first element in the Queue
	 * @return the first element in the Queue
	 */
	public E dequeue() {
		if(isEmpty()) {
			System.out.println("The Queue is empty.");
			return null;
		}
		else {
			Node<E> newFront = front;
			front = front.getNext();
			size--;
			return newFront.getData();
		}
	}
	
	/**
	 * Returns the first element in the Queue
	 * @return the first element in the Queue
	 */
	public E peek() {
		if(isEmpty()) {
			System.out.println("The Queue is empty.");
			return null;
		}
		else {
			return front.getData();
		}
	}
	
	/**
	 * Prints the Queue on the screen
	 */
	public void display() {
		if(isEmpty()) {
			System.out.println("The Queue is empty.");
		}
		else {
			Node<E> curr = front;
			while(curr != back) {
				System.out.println(curr.getData() + ", ");
				curr = curr.getNext();
			}
		}
	}
	
}