/**
 * The implementation of a basic node used for most data structures.
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 * @param <E> generic data type for an element
 */

public class Node<E>{

	//The data to be stored in the node
	private E data;
	//The link to next node
	private Node<E> next;
	//The link to previous node
	private Node<E> prev;
	
	/**
	 * For any data structure
	 */
	public Node() {
		this.data = null;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * For a Linked List
	 * @param data the value in the node
	 * @param next the link to the next node or right child
	 * @param prev the link to the previous node or left child
	 */
	public Node(E data, Node<E> next, Node<E> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	/**
	 * For a Stack or Queue
	 * @param data the value in the node
	 * @param n the top of the Stack or front of the Queue
	 */
	public Node(E data, Node<E> n) {
		this.data = data;
		this.next = n;
	}

	/**
	 * Mutator for data
	 * @param d data to be stored in the node
	 */
	public void setData(E d) {
		this.data = d;
	}
	
	/**
	 * Mutator for next node
	 * @param n the next node
	 */
	public void setNext(Node<E> n) {
		this.next = n;
	}
	
	/**
	 * Mutator for previous node
	 * @param p the previous node
	 */
	public void setPrev(Node<E> p) {
		this.prev = p;
	}
	
	/**
	 * Accessor for data
	 * @return data in the node
	 */
	public E getData() {
		return this.data;
	}
	
	/**
	 * Accessor for next node
	 * @return next node
	 */
	public Node<E> getNext() {
		return this.next;
	}
	
	/**
	 * Accessor for previous node
	 * @return previous node
	 */
	public Node<E> getPrev() {
		return this.prev;
	}
	
}