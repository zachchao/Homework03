package edu.miracosta.cs113;

import static org.junit.Assert.*;

import org.junit.Test;


public class SingleLinkedListTest {
	/**
	 * Test the get method given an index
	 * Assumes the add works and adds to the end each time
	 */
	@Test
	public void getTest() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		//Add 0-9 in order
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}
		//Test that every value is what its supposed to be
		for(int i = 0; i < 10; i++) {
			assertEquals(i, (int)(test.get(i)));
		}
	}
	
	/**
	 * Test the set method
	 * Assumes the get and add method works
	 */
	@Test
	public void setTest() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		//Add 0-9 in order
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}
		//Test setting head
		test.set(0, 10);
		assertEquals(10, (int)(test.get(0)));
		//Test setting middle
		test.set(5, 10);
		assertEquals(10, (int)(test.get(5)));
		//Test setting end
		test.set(9, 10);
		assertEquals(10, (int)(test.get(9)));
	}
	
	/**
	 * Test the size method
	 * Assumes the add method works
	 */
	@Test
	public void sizeTest() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		//Add 0-9 in order
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}
		assertEquals(10, test.size());
		//Add duplicate values 
		for(int i = 0; i < 10; i++) {
			test.add(10);
		}
		assertEquals(20, test.size());
	}
	
	/**
	 * Test the add to end method
	 * Assumes the get method works
	 */
	@Test
	public void addTest() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		//Add 0-9 in order
		for(int i = 0; i < 10; i++) {
			test.add(i);
			assertEquals(i, (int)(test.get(i)));
		}
	}
	
	/**
	 * Test the add to given index method
	 * Assumes the get and add methods works
	 */
	@Test
	public void addIndexTest() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		//Add 0-9 in order
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}
		//Add to head
		test.add(0, 10);
		assertEquals(10, (int)(test.get(0)));
		//Add to middle
		test.add(5, 10);
		assertEquals(10, (int)(test.get(5)));
		//Add to end
		test.add(10, 10);
		assertEquals(10, (int)(test.get(10)));
	}
	
	/**
	 * Test the indexOf method
	 * Assumes the add  method works
	 */
	@Test
	public void indexOfTest() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		//Add 0-9 in order
		for(int i = 0; i < 10; i++) {
			test.add(i);
		}
		//Test that every value is where its supposed to be
		for(int i = 0; i < 10; i++) {
			assertEquals(i, (int)(test.indexOf(i)));
		}
	}
}
