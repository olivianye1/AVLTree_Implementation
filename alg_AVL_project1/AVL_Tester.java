/*
 * Olivia Nye
 * 
 * Tester for AVL Tree
 * 
 * Intro to Algorithms Project 1 - Milestone 1
 * 
 * This class uses unit testing to test the AVLTree class. 
 * Note that build path must use Junit 4 for proper functioning.
 */
package alg_AVL_project1;

import static org.junit.Assert.*;
import org.junit.Test;

import alg_AVL_project1.AVLTree;



public class AVL_Tester {
	@Test
	public void testInsert() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
		myTree.root = myTree.insert(myTree.root, 8);
		myTree.root = myTree.insert(myTree.root, 4);
		myTree.root = myTree.insert(myTree.root, 10);
		myTree.root = myTree.insert(myTree.root, 15);
		myTree.root = myTree.insert(myTree.root, 2);
		assertEquals(true, myTree.contains(myTree.root, 2));
	}
	
	//verifies internal structure after double right rotation
	@Test
	public void testInsert_leftInside() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
		
		myTree.root = myTree.insert(myTree.root, 8);
		myTree.root = myTree.insert(myTree.root, 4);
		myTree.root = myTree.insert(myTree.root, 18);
		myTree.root = myTree.insert(myTree.root, 0);
		myTree.root = myTree.insert(myTree.root, 12);
		myTree.root = myTree.insert(myTree.root, 25);
		myTree.root = myTree.insert(myTree.root, 3); //left inside case: causes double right rotation
		assertTrue((int)myTree.root.left.element == 3);
	}
	
	//verifies internal structure after single right rotation
	@Test
	public void testInsert_leftOutside() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
		myTree.root = myTree.insert(myTree.root, 40);
		myTree.root = myTree.insert(myTree.root, 30);
		myTree.root = myTree.insert(myTree.root, 20); // left outside case: causes a single right rotation
		assertTrue((int)myTree.root.right.element == 40);
	}
	//verifies internal structure after single left rotation
	@Test
	public void testInsert_rightOutside() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
		myTree.root = myTree.insert(myTree.root, 20);
		myTree.root = myTree.insert(myTree.root, 30);
		myTree.root = myTree.insert(myTree.root, 40); // right outside case: causes a single left rotation
		assertTrue((int)myTree.root.left.element == 20);
	}
	
	//verifies internal structure after double left rotation
	@Test
	public void testInsert_rightInside() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
		myTree.root = myTree.insert(myTree.root, 8);
		myTree.root = myTree.insert(myTree.root, 4);
		myTree.root = myTree.insert(myTree.root, 18);
		myTree.root = myTree.insert(myTree.root, 0);
		myTree.root = myTree.insert(myTree.root, 5);
		myTree.root = myTree.insert(myTree.root, 25);
		myTree.root = myTree.insert(myTree.root, 20); //right inside case: causes a double left rotation
		assertTrue((int)myTree.root.right.left.element == 18);
	}
	
	@Test
	public void testRemove() {
		AVLTree<Integer> myTree1 = new AVLTree<Integer>();
			myTree1.root = myTree1.insert(myTree1.root, 8);
			myTree1.root = myTree1.insert(myTree1.root, 4);
			myTree1.root = myTree1.insert(myTree1.root, 10);
			myTree1.root = myTree1.remove(myTree1.root, 4);
			assertEquals(false, myTree1.contains(myTree1.root, 8));
			
	}
	
	@Test
	public void testContains() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
		assertFalse(myTree.contains(myTree.root, 7));
	}
	
	@Test
	public void testRemove_noRot() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
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
		
		assertEquals(false, myTree.contains(myTree.root, 1));
	}
	@Test
	public void testRemove_leaf() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
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
		
		myTree.remove(myTree.root, 0);
		
		assertEquals(false,  myTree.contains(myTree.root, 0) );
	}
	@Test
	public void testRemove_rightOutside() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
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
		
		assertEquals(false,  myTree.contains(myTree.root, 23));
	}
	@Test
	public void testRemove_invalidRemoval() {
		AVLTree<Integer> myTree = new AVLTree<Integer>();
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
		
		myTree.remove(myTree.root, 800);
		
		assertEquals(false,  myTree.contains(myTree.root, 800));
	}
	
	
	@Test
	public void testLeftChild() {
		AVLTree<Integer> myTree1 = new AVLTree<Integer>();
			myTree1.root = myTree1.insert(myTree1.root, 8);
			myTree1.root = myTree1.insert(myTree1.root, 4);
			myTree1.root = myTree1.insert(myTree1.root, 10);
			assertTrue(myTree1.root.left.element == 4);
	}

	@Test
	public void testRightChild() {
		AVLTree<Integer> myTree1 = new AVLTree<Integer>();
			myTree1.root = myTree1.insert(myTree1.root, 8);
			myTree1.root = myTree1.insert(myTree1.root, 4);
			myTree1.root = myTree1.insert(myTree1.root, 10);
			assertTrue(myTree1.root.right.element == 10);
	}
	
	@Test
	public void testRightLeftChild() {
		AVLTree<Integer> myTree1 = new AVLTree<Integer>();
			myTree1.root = myTree1.insert(myTree1.root, 8);
			myTree1.root = myTree1.insert(myTree1.root, 4);
			myTree1.root = myTree1.insert(myTree1.root, 10);
			myTree1.root = myTree1.insert(myTree1.root, 9);
			assertTrue(myTree1.root.right.left.element == 9);
	}
	
	@Test
	public void testBalance() {
		AVLTree<Integer> myTree1 = new AVLTree<Integer>();
		myTree1.root = myTree1.insert(myTree1.root, 8);
		myTree1.root = myTree1.insert(myTree1.root, 4);
		myTree1.root = myTree1.insert(myTree1.root, 10);
		myTree1.root = myTree1.insert(myTree1.root, 9);
		
		assertTrue(myTree1.getBalance(myTree1.root) <= 1);
	}
	
	
	@Test
	public void testHeightNull() {
		AVLTree<Integer> myTree1 = new AVLTree<Integer>();
		assertTrue(myTree1.height(myTree1.root) == -1);
	}
	
	@Test
	public void testHeightOneLevel() {
		AVLTree<Integer> myTree1 = new AVLTree<Integer>();
		myTree1.root = myTree1.insert(myTree1.root, 8);
		assertTrue(myTree1.height(myTree1.root) == 0);
	}
	
	


}





