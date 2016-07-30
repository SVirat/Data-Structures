/**
 * The implementation of a general Binary Tree. 
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 * @param <E> generic data type for an element
 */

public class BinaryTree<E> {

	//The first node of the tree
	protected TreeNode<E> root;

	/**
	 * Contructor to create a Binary Tree
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Checks whether the tree has any elements
	 * @return true if the tree has any elements
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Adds an element in the tree
	 * @param data
	 */
	public void insert(E data) {
		root = insert(data, root);
	}

	/**
	 * Helper method to add the element in the tree
	 * @param data the element to be added
	 * @param node the node from where the element starts to be added
	 * @return the node which in which the element tries to be added
	 */
	private TreeNode<E> insert(E data, TreeNode<E> node) {
		if(isEmpty()) {
			node = new TreeNode<E>(data);	
		}
		else {
			if(node.getLeft() == null) {
				node.setLeft(insert(data, node.getLeft()));
			}
			else {
				node.setRight(insert(data, node.getRight()));
			}
		}
		return node;
	}

	/**
	 * The size of the tree
	 * @return the number of elements in the tree
	 */
	public int countNodes() {
		return countNodes(root);
	}

	/**
	 * Helper method to count the number of elements in the tree
	 * @param node the node's whose children are being counted, plus itself
	 * @return the number of elements underneath the node, plus itself
	 */
	private int countNodes(TreeNode<E> node) {
		if(isEmpty()) {
			return 0;
		}
		else {
			int count = 1;
			count += countNodes(node.getLeft());
			count += countNodes(node.getRight());
			return count;
		}
	}

	/**
	 * Whether the given element is present in the tree
	 * @param data the element to search for
	 * @return true if the element is present in the tree
	 */
	public boolean search(E data) {
		return search(data, root);
	}

	/**
	 * Helper method to search for the element
	 * @param data the element to search for
	 * @param node the node below which to search from
	 * @return true if the element is present in the tree
	 */
	private boolean search(E data, TreeNode<E> node) {
		if(node.getData() == data) {
			return true;
		}
		if(node.getLeft() != null) {
			if(search(data, node.getLeft())) {
				return true;
			}
		}
		if(node.getRight() != null) {
			if(search(data, node.getRight())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints out the tree from left to right.
	 */
	public void inorder() {
		inorder(root);
	}

	/**
	 * Helper method to print out the tree from left to right
	 * @param node the root of the tree
	 */
	private void inorder(TreeNode<E> node) {
		if(node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + ", ");
			inorder(node.getRight());
		}
	}

	/**
	 * Prints the tree from top-left to right
	 */
	public void preorder() {
		preorder(root);
	}

	/**
	 * Helper method to print out the tree from top-left to right
	 * @param node the root of the tree
	 */
	private void preorder(TreeNode<E> node) {
		if (node != null) {
			System.out.print(node.getData() + ", ");
			preorder(node.getLeft());             
			preorder(node.getRight());
		}
	}

	/**
	 * Prints the tree from left, right, and then to top
	 */
	public void postorder() {
		postorder(root);
	}

	/**
	 * Helper method to print out the tree from left, right, and then top
	 * @param node the root of the tree
	 */
	private void postorder(TreeNode<E> node) {
		if (node != null) {
			postorder(node.getLeft());             
			postorder(node.getRight());
			System.out.print(node.getData() + ", ");
		}
	}

	public int compareTo(TreeNode<E> o) {
		if(root.getData().equals(o.getData())) {
			return 0;
		}
		if((double)root.getData() > (double)o.getData()) {
			return 1;
		}
		return -1;
	}

}