/**
 * The implementation of a Heap. It is created using arrays due to lower
 * time complexities.
 * 
 * @author Virat Singh, svirat@gmail.com
 *
 */

import java.util.NoSuchElementException;

public class Heap {

	//the heap
	private double heap[];
	//the number of elements in the heap
	private int size;
	//this heap is a binary tree
	private final static int NUM_CHILDREN = 2;

	/**
	 * Constructor for creating the Heap
	 * @param size the number of elements that can be stored in the Heap
	 */
	public Heap(int size) {
		this.size = size;
		this.heap = new double[size + 1];
	}

	/**
	 * Whether there are any elements in the Heap
	 * @return true if there are no elements
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Whether there is no more space in the Heap
	 * @return true if no more space is available
	 */
	public boolean isFull() {
		return size == heap.length;
	}

	/**
	 * Find where in Heap the parent of the current element is located
	 * @param i the position of the child
	 * @return the position of the parent
	 */
	private int parent(int i) {
		return (i - 1)/NUM_CHILDREN;
	}

	/**
	 * Returns the specified child's position
	 * @param i the current element's position
	 * @param k the child
	 * @return the child's position
	 */
	private int kthChild(int i, int k)  {
		return NUM_CHILDREN * i + k;
	}

	/**
	 * Adds the element in the Heap
	 * @param data the element to be added in the Heap
	 */
	public void insert(double data) {
		if(isFull()) {
			System.out.println("The Heap is full.");
		}
		else {
			heap[size++] = data;
			heapifyUp(size - 1);
		}
	}

	/**
	 * Removes and returns the element in a specified position
	 * @param pos the position of the element to remove
	 * @return the element in the specified position
	 */
	public double delete(int pos) {
		if (isEmpty() ) {
			throw new NoSuchElementException("Underflow Exception");
		}
		double keyItem = heap[pos];
		heap[pos] = heap[size - 1];
		size--;
		heapifyDown(pos);        
		return keyItem;
	}

	/**
	 * Returns the smallest element in the Heap
	 * @return the smallest (first) element in the Heap
	 */
	public double findMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("Underflow Exception");
		}
		else{
			return heap[0];
		}
	}

	/**
	 * Returns and deletes the smallest element in the Heap
	 * @return the smallest (first) element in the Heap
	 */
	public double deleteMin() {
		if(isEmpty()) {
			throw new NoSuchElementException("Underflow Exception");
		}
		else {
			double keyItem = heap[0];
			delete(0);
			return keyItem;
		}
	}

	/**
	 * Restores Heap properties once an element is added
	 * @param childIndex the index from which the Heap's property is restored
	 */
	private void heapifyUp(int childIndex) {
		double tmp = heap[childIndex];    
		while (childIndex > 0 && tmp < heap[parent(childIndex)]) {
			heap[childIndex] = heap[ parent(childIndex) ];
			childIndex = parent(childIndex);
		}                   
		heap[childIndex] = tmp;
	}

	/**
	 * Restores Heap properties once an element is added
	 * @param index the index from which the Heap's property is restored
	 */
	private void heapifyDown(int index) {
		int child;
		double tmp = heap[ index ];
		while (kthChild(index, 1) < size) {
			child = minChild(index);
			if (heap[child] < tmp)
				heap[index] = heap[child];
			else
				break;
			index = child;
		}
		heap[index] = tmp;
	}

	/**
	 * gives back the minimum child of an element
	 * @param ind the position from which to start searching
	 * @return the minimum child
	 */
	private int minChild(int ind) {
		int bestChild = kthChild(ind, 1);
		int k = 2;
		int pos = kthChild(ind, k);
		while ((k <= NUM_CHILDREN) && (pos < size)) 
		{
			if (heap[pos] < heap[bestChild]) 
				bestChild = pos;
			pos = kthChild(ind, k++);
		}    
		return bestChild;
	}

	/**
	 * Prints the Heap to the screen
	 */
	public void printHeap() {
		System.out.print("\nHeap = ");
		for (int i = 0; i < size; i++)
			System.out.print(heap[i] +" ");
		System.out.println();
	}     
	
}