/**
 * The implementation of a Binary Search Tree. Most methods are inherited from
 * BinaryTree.java, but some are reimplemented either for specific requirements 
 * of Binary Search Trees or for faster time complexities.
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 * @param <E> A generic data type
 */
public class BinarySearchTree<E> extends BinaryTree<E> {

	/**
	 * Constructor for creating a Binary Search Tree
	 */
	public BinarySearchTree() {
		this.root = null;
	}

	/**
	 * Adding an element into the BST
	 */
	public void insert(E data) {
		root = insert(data, root);
	}

	/**
	 * Helper method for adding an element into the BST
	 * @param data the element to be added
	 * @param node the node from where the element starts to be added
	 * @return the node which in which the element tries to be added
	 */
	private TreeNode<E> insert(E data, TreeNode<E> node) {
		if (isEmpty()) {
			node = new TreeNode<E>(data);
		}
		else {
			if (((Comparable <E>) data).compareTo(node.getData()) <= 0)
				node.setLeft(insert(data, node.getLeft()));
			else
				node.setRight(insert(data, node.getRight()));
		}
		return node;
	}

	/**
	 * Remove an element from the BST
	 * @param data the element to be removed
	 */
	public void delete(E data) {
		if (isEmpty()) {
			System.out.println("Tree Empty");
		}
		else if (search(data) == false)
			System.out.println("Sorry "+ data + " is not present");
		else {
			root = delete(data, root);
			System.out.println(data + " deleted from the tree");
		}
	}

	/**
	 * Helper method to remove data from a BST
	 * @param data the element to be removed
	 * @param node the node from where the element starts to be deleted
	 * @return the node which in which the element tries to be deleted
	 */
	private TreeNode<E> delete(E data, TreeNode<E> node) {
		TreeNode<E> p, p2, n;
		if (node.getData() == data) {
			TreeNode<E> lt, rt;
			lt = node.getLeft();
			rt = node.getRight();
			if (lt == null && rt == null)
				return null;
			else if (lt == null) {
				p = rt;
				return p;
			}
			else if (rt == null) {
				p = lt;
				return p;
			}
			else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
		if (((Comparable <E>) data).compareTo(node.getData()) < 0) {
			n = delete(data, node.getLeft());
			node.setLeft(n);
		}
		else {
			n = delete(data, node.getRight());
			node.setRight(n);             
		}
		return node;
	}

	/**
	 * Search is the element is in the BST
	 * @param val the element to be searched for
	 * @return true if the element was found
	 */
	public boolean search(E val) {
		return search(root, val);
	}

	/**
	 * Helper method for searching for an element in the BST
	 * It is reimplemented for BST due to better time complexity
	 * @param node the node where search is being conducted
	 * @param val the element to search for
	 * @return true if the element was found
	 */
	private boolean search(TreeNode<E> node, E val) {
		boolean found = false;
		while ((node != null) && !found) {
			E rval = node.getData();
			if (((Comparable <E>) val).compareTo(rval) < 0)
				node = node.getLeft();
			else if (((Comparable <E>) val).compareTo(rval) > 0)
				node = node.getRight();
			else {
				found = true;
				break;
			}
			found = search(node, val);
		}
		return found;
	}

}