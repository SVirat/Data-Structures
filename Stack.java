/**
 * The implementation of a Stack using Linked Lists.
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 * @param <E> generic data type for an element
 */

public class Stack<E> {

	//the first Node<E> in the Stack
	private Node<E> top;
	//the current size of the Stack
	private int size;
	
	/**
	 * Constructor for creating a Stack
	 */
	public Stack() {
		this.size = 0;
		this.top = null;
	}
	
	/**
	 * The number of Node<E>s currently in the Stack
	 * @return size of the Stack
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Whether there are any elements in the Stack
	 * @return true if there are no elements in the Stack
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param data the value to put on the top of the Stack
	 */
	public void push(E data) {
		Node<E> node = new Node<E>(data, null, null);
		if(isEmpty()) {
			top = node;
		}
		else {
			node.setNext(top);
			top = node;
		}
		size++;
	}
	
	/**
	 * Removes and returns the top most element of the Stack
	 * @return top most element in the Stack
	 */
	public E pop() {
		if(isEmpty()) {
			System.out.println("The Stack is empty.");
			return null;
		}
		else {
			Node<E> node = top;
			top = node.getNext();
			size--;
			return top.getData();
		}
	}
	
	/**
	 * Returns the top most element of the Stack, but does not remove it
	 * @return top most element in the Stack
	 */
	public E peek() {
		if(isEmpty()) {
			System.out.println("The Stack is empty.");
			return null;
		}
		else {
			return top.getData();
		}
	}
	
	/**
	 * Prints the Stack on the screen
	 */
	public void display() {
		if(isEmpty()) {
			System.out.println("The Stack is empty.");
		}
		else {
			Node<E> curr = top;
			while (curr != null) {
				System.out.print(curr.getData() + ", ");
				curr = curr.getNext();
			}
		}
	}
	
}