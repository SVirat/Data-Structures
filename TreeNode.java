/**
 * The implementation of a basic node used for a tree data structure.
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 * @param <E> generic data type for an element
 */

public class TreeNode<E>{

	//The data to be stored in the node
	protected E data;
	//The link to left node
	protected TreeNode<E> right;
	//The link to right node
	protected TreeNode<E> left;
	
	/**
	 * For any data structure
	 */
	public TreeNode() {
		this.data = null;
		this.right = null;
		this.left = null;
	}
	
	public TreeNode(E data) {
		this.data = data;
		this.right = null;
		this.left = null;
	}
	
	/**
	 * Mutator for data
	 * @param d data to be stored in the node
	 */
	public void setData(E d) {
		this.data = d;
	}
	
	/**
	 * Mutator for right node
	 * @param n the right node
	 */
	public void setRight(TreeNode<E> n) {
		this.right = n;
	}
	
	/**
	 * Mutator for left node
	 * @param p the left node
	 */
	public void setLeft(TreeNode<E> p) {
		this.left = p;
	}
	
	/**
	 * Accessor for data
	 * @return data in the node
	 */
	public E getData() {
		return this.data;
	}
	
	/**
	 * Accessor for right node
	 * @return right node
	 */
	public TreeNode<E> getRight() {
		return this.right;
	}
	
	/**
	 * Accessor for left node
	 * @return left node
	 */
	public TreeNode<E> getLeft() {
		return this.left;
	}
	
}