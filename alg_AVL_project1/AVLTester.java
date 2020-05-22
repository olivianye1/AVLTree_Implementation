//package alg_AVL_project1;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import junit.framework.*;

// https://github.com/justinethier/AVL-Tree/blob/master/src/test/java/justinethier/AvlTreeTest.java
public class AVLTester<E> extends TestCase{

	
	public AVLTree<Integer> myTree = new AVLTree<Integer>();
	
	
	
	@Override
	protected void setUp() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
		
		
		
	}
	
	@Override
	protected void tearDown() {
		myTree = null;
	} 
	
	//public static void main(String[] args) {
	
	
	
	public void firstInsertionTest() {
		myTree.insert(myTree.root, 4); 
		System.out.println((int)myTree.root.element);
		assertEquals(4, (int)myTree.root.element);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.main(new String[] {"AVLTester"});
	}
		 
//		myTree.insert(myTree.root, 8); 
//		
//		myTree.insert(myTree.root, 18); // right outside case: causes a single left rotation
//		myTree.insert(myTree.root, 12);
//		myTree.insert(myTree.root, 0);
//		myTree.insert(myTree.root, 25);
//		myTree.insert(myTree.root, 3); // left inside  case: causes a double right rotation
//		myTree.insert(myTree.root, 1);
//		myTree.insert(myTree.root, 15);
//		myTree.insert(myTree.root, 16); // right outside case: causes a single left rotation
//		myTree.insert(myTree.root, 23);
//		myTree.insert(myTree.root, 42);
//		
//		System.out.println(myTree.getBalance(myTree.root));
//		assertTrue(myTree.getBalance(myTree.root) <= 1 && myTree.getBalance(myTree.root) >= -1);
//		
		
		//boolean check;
		//check = (myTree.root.element == 4);
		//System.out.println(check);
		//assertTrue(check);
		
		
		//String treeOrder = myTree.printInOrder(myTree.root);
		//System.out.println("firstInsertion " + treeOrder );
		//assertEquals(" 0 1 3 4 8 12 15 16 18 23 25 42 ", treeOrder);
	}
	
	/*
	public void secondInsertionTest() {
		myTree.insert(myTree.root, 40);
		myTree.insert(myTree.root, 30);
		myTree.insert(myTree.root, 20); // left outside case: causes a single right rotation
		myTree.insert(myTree.root, 48);
		myTree.insert(myTree.root, 44); //inside right case: causes a double left rotation
//		String treeOrder = myTree.printInOrder(myTree.root);
//		System.out.println("secondInsertion " + treeOrder );
//		assertEquals(" 20 30 40 44 48 ", treeOrder);
	}
	
	public void testRemove_Balance() {
		myTree.insert(myTree.root, 4);
		myTree.insert(myTree.root, 8);
		myTree.insert(myTree.root, 18); 
		myTree.insert(myTree.root, 12);
		myTree.insert(myTree.root, 0);
		myTree.insert(myTree.root, 25);
		myTree.insert(myTree.root, 3); 
		myTree.insert(myTree.root, 1);
		myTree.insert(myTree.root, 15);
		myTree.insert(myTree.root, 16);
		myTree.insert(myTree.root, 23);
		myTree.insert(myTree.root, 42);
		
		myTree.remove(myTree.root, 1);
//		String treeOrder = myTree.printInOrder(myTree.root);
//		System.out.println("testRemove_Balance " + treeOrder );
//		assertEquals(" 0 3 4 8 12 15 16 18 23 25 42 ", treeOrder);
	}
	
	public void testRemove_leftInside() {
		myTree.insert(myTree.root, 4);
		myTree.insert(myTree.root, 8);
		myTree.insert(myTree.root, 18); 
		myTree.insert(myTree.root, 12);
		myTree.insert(myTree.root, 0);
		myTree.insert(myTree.root, 25);
		myTree.insert(myTree.root, 3); 
		myTree.insert(myTree.root, 1);
		myTree.insert(myTree.root, 15);
		myTree.insert(myTree.root, 16);
		myTree.insert(myTree.root, 23);
		myTree.insert(myTree.root, 42);
		
		myTree.remove(myTree.root, 4);
//		String treeOrder = myTree.printInOrder(myTree.root);
//		System.out.println("testRemove_leftInside " + treeOrder );
//		assertEquals(" 0 1 3 8 12 15 16 18 23 25 42 ", treeOrder);
	}
	public void testRemove_rightInside() {
		myTree.insert(myTree.root, 4);
		myTree.insert(myTree.root, 8);
		myTree.insert(myTree.root, 18); 
		myTree.insert(myTree.root, 12);
		myTree.insert(myTree.root, 0);
		myTree.insert(myTree.root, 25);
		myTree.insert(myTree.root, 3); 
		myTree.insert(myTree.root, 1);
		myTree.insert(myTree.root, 15);
		myTree.insert(myTree.root, 16);
		myTree.insert(myTree.root, 23);
		myTree.insert(myTree.root, 42);
		
		myTree.remove(myTree.root, 12);
		myTree.remove(myTree.root, 16);
//		String treeOrder = myTree.printInOrder(myTree.root);
//		System.out.println("testRemove_rightInside " + treeOrder );
//		assertEquals(" 0 3 4 8 15 18 23 25 42 ", treeOrder);
		
	}
	public void testRemove_rightOutside() {
		myTree.insert(myTree.root, 4);
		myTree.insert(myTree.root, 8);
		myTree.insert(myTree.root, 18); 
		myTree.insert(myTree.root, 12);
		myTree.insert(myTree.root, 0);
		myTree.insert(myTree.root, 25);
		myTree.insert(myTree.root, 3); 
		myTree.insert(myTree.root, 1);
		myTree.insert(myTree.root, 15);
		myTree.insert(myTree.root, 16);
		myTree.insert(myTree.root, 23);
		myTree.insert(myTree.root, 42);
		
		myTree.insert(myTree.root, 44);
		myTree.remove(myTree.root, 23);
//		String treeOrder = myTree.printInOrder(myTree.root);
//
//		System.out.println("testRemove_rightOutside " + treeOrder );
//		assertEquals(" 0 3 4 8 15 18 25 42 44 ", treeOrder);		
	}
	public void testRemove_invalid() {
		myTree.insert(myTree.root, 4);
		myTree.insert(myTree.root, 8);
		myTree.insert(myTree.root, 18); 
		myTree.insert(myTree.root, 12);
		myTree.insert(myTree.root, 0);
		myTree.insert(myTree.root, 25);
		myTree.insert(myTree.root, 3); 
		myTree.insert(myTree.root, 1);
		myTree.insert(myTree.root, 15);
		myTree.insert(myTree.root, 16);
		myTree.insert(myTree.root, 23);
		myTree.insert(myTree.root, 42);

		myTree.remove(myTree.root, 800);
//
//		String treeOrder = myTree.printInOrder(myTree.root);
//		System.out.println("testRemove_invalid " + treeOrder );
//		assertEquals(" 0 1 3 4 8 12 15 16 18 23 25 42 ", treeOrder);	
//		
	}
	//test contains when it should be true (element in tree) 
	public void testContainsTrue() {

		myTree.insert(myTree.root, 4);
		myTree.insert(myTree.root, 8);
		myTree.insert(myTree.root, 18); 
		myTree.insert(myTree.root, 12);
		myTree.insert(myTree.root, 0);
		myTree.insert(myTree.root, 25);
		myTree.insert(myTree.root, 3); 
		myTree.insert(myTree.root, 1);
		myTree.insert(myTree.root, 15);
		myTree.insert(myTree.root, 16);
		myTree.insert(myTree.root, 23);
		myTree.insert(myTree.root, 42);
		
		//treeOrder just for show
//		String treeOrder = myTree.printInOrder(myTree.root);
//		System.out.println("testcontains true " + treeOrder );
//		assertTrue(myTree.contains(myTree.root, 18));
	}
	
	//test contains when it should be false (element not in tree)
	public void testContainsFalse() {

		myTree.insert(myTree.root, 4);
		myTree.insert(myTree.root, 8);
		myTree.insert(myTree.root, 18); 
		myTree.insert(myTree.root, 12);
		myTree.insert(myTree.root, 0);
		myTree.insert(myTree.root, 25);
		myTree.insert(myTree.root, 3); 
		myTree.insert(myTree.root, 1);
		myTree.insert(myTree.root, 15);
		myTree.insert(myTree.root, 16);
		myTree.insert(myTree.root, 23);
		myTree.insert(myTree.root, 42);
		

		//treeOrder just for show
//		String treeOrder = myTree.printInOrder(myTree.root);
//		System.out.println("testcontains false " + treeOrder );
//		assertFalse(myTree.contains(myTree.root, 800));		
	}

	public static void main(String[] args) {
		//junit.textui.TestRunner.main(new String[] {"AVLTester"});
		
		firstInsertionTest();
	}

	
}*/
