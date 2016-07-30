/**
 * Implementation for almost all data structures taught throughout college.
 * 
 * @author Virat Singh, svirat@gmail.com
 */

import java.util.Scanner;

public class DataStructures {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int choice;

		do {

			System.out.println("Choose a data structure to use: ");
			System.out.println("0. Exit");
			System.out.println("1. Linked List");
			System.out.println("2. Binary Tree");
			System.out.println("3. Stack");
			System.out.println("4. Queue");
			System.out.println("5. Heap");
			choice = input.nextInt();

			if(choice == 1) {
				System.out.println("This is a doubly linked circular list.");;
				System.out.println("1. Insert");
				System.out.println("2. Insert at position");
				System.out.println("3. Delete at position");
				System.out.println("4. Check empty");
				System.out.println("5. Get size");
				int innerChoice = input.nextInt();
				linkedListChoice(innerChoice);
			}
			else if(choice == 2) {
				System.out.println("This is a binary tree.");
				System.out.println("1. Insert ");
				System.out.println("2. Search");
				System.out.println("3. Count nodes");
				System.out.println("4. Check empty");
				int innerChoice = input.nextInt();
				binaryTreeChoice(innerChoice);
			}
			else if(choice == 3) {
				System.out.println("This is a stack.");
				System.out.println("1. Push");
				System.out.println("2. Pop");
				System.out.println("3. Peek");
				System.out.println("4. Check empty");
				System.out.println("5. Size");            
				int innerChoice = input.nextInt();
				stackChoice(innerChoice);
			}
			else if(choice == 4) {
				System.out.println("This is a queue.");
				System.out.println("1. Enqueue");
				System.out.println("2. Dequeue");
				System.out.println("3. Peek");
				System.out.println("4. Check empty");
				System.out.println("5. Size");
				int innerChoice = input.nextInt();
				queueChoice(innerChoice);
			}
			else if(choice == 5) {
				System.out.println("This is a min-Heap.");
				System.out.println("How big should the Heap be?");
				int size = input.nextInt();
				System.out.println("\nBinary Heap Operations\n");
				System.out.println("1. Insert ");
				System.out.println("2. Delete min");
				System.out.println("3. Check full");            
				System.out.println("4. Check empty");
				System.out.println("5. Clear");
				int innerChoice = input.nextInt(); 
				heapChoice(innerChoice, size);
			}


		} while(choice >= 0 && choice <= 5);


		input.close();

	}	

	public static void linkedListChoice(int choice) {

		Scanner scan = new Scanner(System.in);
		LinkedList<Object> linkedList = new LinkedList<Object>();
		char ch;
		do {
			switch (choice) {
			case 1 : 
				System.out.println("Enter integer element to insert");
				linkedList.add( scan.nextInt() );                     
				break;                          
			case 2 : 
				System.out.println("Enter integer element to insert");
				linkedList.add( scan.nextInt() );                     
				break;                         
			case 3 : 
				System.out.println("Enter integer element to insert");
				int num = scan.nextInt() ;
				System.out.println("Enter position");
				int pos = scan.nextInt() ;
				if (pos < 1 || pos > linkedList.getSize() )
					System.out.println("Invalid position\n");
				else
					linkedList.addAtPos(num, pos);
				break;                                          
			case 4 : 
				System.out.println("Enter position");
				int p = scan.nextInt() ;
				if (p < 1 || p > linkedList.getSize() )
					System.out.println("Invalid position\n");
				else
					linkedList.removeAtPos(p);
				break;     
			case 5 : 
				System.out.println("Empty status = "+ linkedList.isEmpty());
				break;            
			case 6 : 
				System.out.println("Size = "+ linkedList.getSize() +" \n");
				break;                         
			default : 
				System.out.println("Wrong Entry \n ");
				break;   
			}
			/*  Display List  */ 
			linkedList.display();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);                        
		} while (ch == 'Y'|| ch == 'y');
		scan.close();
	}

	public static void binaryTreeChoice(int choice) {
		Scanner scan = new Scanner(System.in);
		BinaryTree<Object> binaryTree = new BinaryTree<Object>();
		char ch;
		do {
			switch (choice) {
			case 1 : 
				System.out.println("Enter integer element to insert");
				binaryTree.insert( scan.nextInt() );                     
				break;                          
			case 2 : 
				System.out.println("Enter integer element to search");
				System.out.println("Search result : "+ binaryTree.search( (Object)scan.nextInt() ));
				break;                                          
			case 3 : 
				System.out.println("Nodes = "+ binaryTree.countNodes());
				break;     
			case 4 : 
				System.out.println("Empty status = "+ binaryTree.isEmpty());
				break;            
			default : 
				System.out.println("Wrong Entry \n ");
				break;   
			}
			/*  Display tree  */ 
			System.out.print("\nPost order : ");
			binaryTree.postorder();
			System.out.print("\nPre order : ");
			binaryTree.preorder();
			System.out.print("\nIn order : ");
			binaryTree.inorder();

			System.out.println("\n\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);                        
		} while (ch == 'Y'|| ch == 'y'); 
		scan.close();
	}

	public static void stackChoice(int choice) {
		Scanner scan = new Scanner(System.in);
		Stack<Object> stack = new Stack<Object>();
		char ch;
		do {
			switch (choice)  {
			case 1 :
				System.out.println("Enter integer element to push");
				stack.push( scan.nextInt() ); 
				break;                         
			case 2 : 
				try
				{
					System.out.println("Popped Element = "+ stack.pop());
				}
				catch (Exception e)
				{
					System.out.println("Error : " + e.getMessage());
				}    
				break;                         
			case 3 : 
				try
				{
					System.out.println("Peek Element = "+ stack.peek());
				}
				catch (Exception e)
				{
					System.out.println("Error : " + e.getMessage());
				}
				break;                         
			case 4 : 
				System.out.println("Empty status = "+ stack.isEmpty());
				break;                
			case 5 : 
				System.out.println("Size = "+ stack.getSize()); 
				break;                
			case 6 : 
				System.out.println("Stack = "); 
				stack.display();
				break;                        
			default : 
				System.out.println("Wrong Entry \n ");
				break;
			}           
			/* display stack */    
			stack.display();            
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);       
		} while (ch == 'Y'|| ch == 'y');
		scan.close();
	}

	public static void queueChoice(int choice) {
		Scanner scan = new Scanner(System.in);
		Queue<Object> queue = new Queue<Object>();
		char ch;
		do {
			switch (choice) {
			case 1 : 
				System.out.println("Enter integer element to insert");
				queue.enqueue( scan.nextInt() );
				break;                         
			case 2 : 
				try 
				{
					System.out.println("Removed Element = "+ queue.dequeue());
				}
				catch (Exception e)
				{
					System.out.println("Error : " + e.getMessage());
				}    
				break;                         
			case 3 : 
				try
				{
					System.out.println("Peek Element = "+ queue.peek());
				}
				catch (Exception e)
				{
					System.out.println("Error : " + e.getMessage());
				}
				break;                         
			case 4 : 
				System.out.println("Empty status = "+ queue.isEmpty());
				break;

			case 5 : 
				System.out.println("Size = "+ queue.getSize());
				break;  

			default : 
				System.out.println("Wrong Entry \n ");
				break;
			}                
			/* display queue */        
			queue.display();

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);            
		} while (ch == 'Y'|| ch == 'y');
		scan.close();
	}

	public static void heapChoice(int choice, int size) {

		Scanner scan = new Scanner(System.in);
		Heap heap = new Heap(size);
		char ch;

		do {
			switch (choice)
			{
			case 1 : 
				try
				{
					System.out.println("Enter integer element to insert");
					heap.insert( scan.nextInt() ); 
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage() );
				}
				break;                          
			case 2 : 
				try
				{
					System.out.println("Min Element : "+ heap.deleteMin()); 
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage() );
				}                 
				break;                                
			case 3 : 
				System.out.println("Full status = "+ heap.isFull());
				break;                                   
			case 4 : 
				System.out.println("Empty status = "+ heap.isEmpty());
				break;        
			default : 
				System.out.println("Wrong Entry \n ");
				break;   
			}
			heap.printHeap();  

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);                        
		} while (ch == 'Y'|| ch == 'y');  
		scan.close();
	}

}