/**
 * Olivia Nye
 * 
 * AVL Tree Runtime Tester Class
 * 
 * Intro to Algorithms Project 1 - Milestone 3
 * 
 * This class analyzes the runtime complexity of the AVL tree's contains method by running 7,0000 tests across 7 tree sizes
 *  */
package alg_AVL_project1;

import java.util.*;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class AVL_RuntimeTester {
	
	//function generates random list of listSize elements
	public AVLTree<Integer> createRandAVL(int treeSize){
		AVLTree<Integer> randAVL = new AVLTree<Integer>();
		Random random = new Random(100);
		int newNum;
		int numNodes = 0;
		while (numNodes < treeSize) {
			newNum = random.nextInt();
			//do not add duplicate numbers
			if (!randAVL.contains(randAVL.root, newNum)) {
				randAVL.insert(randAVL.root, newNum); 
				numNodes ++;
			} 

		}
		return randAVL;
	}  
	
	//exports all runtime results to a CSV file
	public void writeToCSV(long[] runtimeList, String filename) throws IOException {
		File csv = new File(filename);
		FileWriter fw = new FileWriter(csv);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Runtimes");
		bw.newLine();
		
		for (int i = 0; i < runtimeList.length; i++) {
			//convert runtimeList[i] to string type because bw.write cannot handle long data
			bw.write(String.valueOf(runtimeList[i]));
			bw.newLine(); 
		}
		bw.close();
		fw.close();
	} 

	@Test
	public void contains1() throws IOException {
		long[] runTimes = new long[1000];
		//perform 1000 trials
		for (int i = 0; i < 1000; i++) {
			AVLTree<Integer> myTree = new AVLTree<Integer>();
			myTree = createRandAVL(1);
			
			long startTime = System.nanoTime();
			myTree.contains(myTree.root, 18);
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			//add runtime of trial to runTimes list
			runTimes[i] = totalTime;
		}
		writeToCSV(runTimes, "AVLcontains1.csv");
	}
	

	@Test
	public void contains10() throws IOException {
		long[] runTimes = new long[1000];
		//perform 1000 trials
		for (int i = 0; i < 1000; i++) {
			AVLTree<Integer> myTree = new AVLTree<Integer>();
			myTree = createRandAVL(10);
			
			long startTime = System.nanoTime();
			myTree.contains(myTree.root, 18);
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			//add runtime of trial to runTimes list
			runTimes[i] = totalTime;
		}
		writeToCSV(runTimes, "AVLcontainsTen.csv");
	}
	

	@Test
	public void contains100() throws IOException {
		long[] runTimes = new long[1000];
		//perform 1000 trials
		for (int i = 0; i < 1000; i++) {
			AVLTree<Integer> myTree = new AVLTree<Integer>();
			myTree = createRandAVL(100);
			
			long startTime = System.nanoTime();
			myTree.contains(myTree.root, 18);
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			//add runtime of trial to runTimes list
			runTimes[i] = totalTime;
		}
		writeToCSV(runTimes, "AVLcontainsHundred.csv");
	}
	
	@Test
	public void contains1000() throws IOException {
		long[] runTimes = new long[1000];
		//perform 1000 trials
		for (int i = 0; i < 1000; i++) {
			AVLTree<Integer> myTree = new AVLTree<Integer>();
			myTree = createRandAVL(1000);
			
			long startTime = System.nanoTime();
			myTree.contains(myTree.root, 18);
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			//add runtime of trial to runTimes list
			runTimes[i] = totalTime;
		}
		writeToCSV(runTimes, "AVLcontainsThousand.csv");
	}
	@Test 
	public void contains10000() throws IOException {
		long[] runTimes = new long[1000];
		//perform 1000 trials
		for (int i = 0; i < 1000; i++) {
			AVLTree<Integer> myTree = new AVLTree<Integer>();
			myTree = createRandAVL(10000);
			
			long startTime = System.nanoTime();
			myTree.contains(myTree.root, 18);
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			//add runtime of trial to runTimes list
			runTimes[i] = totalTime;
		}
		writeToCSV(runTimes, "AVLcontains10Thousand.csv");
	}
	
	@Test
	public void contains100000() throws IOException {
		long[] runTimes = new long[1000];
		//perform 1000 trials
		for (int i = 0; i < 1000; i++) {
			AVLTree<Integer> myTree = new AVLTree<Integer>();
			myTree = createRandAVL(100000);
			
			long startTime = System.nanoTime();
			myTree.contains(myTree.root, 18);
			long endTime = System.nanoTime(); 
			long totalTime = endTime - startTime;
			//add runtime of trial to runTimes list
			runTimes[i] = totalTime;
		}
		writeToCSV(runTimes, "AVLcontains100Thousand.csv");
	}
	
	@Test
	public void contains1000000() throws IOException {
		long[] runTimes = new long[1000];
		//perform 1000 trials
		for (int i = 0; i < 1000; i++) {
			AVLTree<Integer> myTree = new AVLTree<Integer>();
			myTree = createRandAVL(1000000);
			
			long startTime = System.nanoTime();
			myTree.contains(myTree.root, 18);
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			//add runtime of trial to runTimes list
			runTimes[i] = totalTime;
		} 
		writeToCSV(runTimes, "AVLcontainsMillion.csv");
	}

}

