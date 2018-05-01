package test2;

import static org.junit.Assert.*;

import org.junit.Test;

import q2.Queue;

/**
 * A test suite for the Queue class
 * 
 * @author Samanjate Sood
 *
 */
public class QueueTests {

	/**
	 * A method to test the add functionality of the queue
	 * 
	 * The test cases are are for Integer values:
	 * 1) Adds non-uniformly distributed numbers.
	 * 2) Last added element is the one that can be peeked, this ensure it was added
	 */
	@Test
	public void testAddIntegers() {
		Queue<Integer> q = new Queue<Integer>();
		q.add(4);
		assertEquals("The last element added should be 4", new Integer(4), q.peek());
		
		q.add(5);
		assertEquals("The last element added should be 5", new Integer(5), q.peek());
		
		q.add(122);
		assertEquals("The last element added should be 122", new Integer(122), q.peek());
		
		q.add(-1);
		assertEquals("The last element added should be -1", new Integer(-1), q.peek());
		
		q.add(0);
		assertEquals("The last element added should be 0", new Integer(0), q.peek());
		
		q.add(100000);
		assertEquals("The last element added should be 100000", new Integer(100000), q.peek());
	}
	
	/**
	 * A method to test the add functionality of the queue
	 * 
	 * The test cases are are for String values:
	 * 1) Last added element is the one that can be peeked, this ensure it was added
	 */
	@Test
	public void testAddStrings() {
		Queue<String> q = new Queue<String>();
		q.add("");
		assertEquals("The last element added should be empty string", "", q.peek());
		
		q.add("Saman");
		assertEquals("The last element added should be empty string", "Saman", q.peek());
		
		q.add("Sood");
		assertEquals("The last element added should be empty string", "Sood", q.peek());
	}
	
	/**
	 * A method to test the peek functionality of the queue
	 * 
	 * The test cases are are for Integer values:
	 * 1) Calling peek twice doesn't remove the element from the queue
	 * 2) Peek on an empty queue returns null
	 */
	@Test
	public void testPeekIntegers() {
		Queue<Integer> q = new Queue<Integer>();
		
		assertNull("Peek on empty queue should return null", q.peek());
		
		q.add(4);
		assertEquals("Peek should return 4", new Integer(4), q.peek());
		assertEquals("Peek should return 4", new Integer(4), q.peek());
		
		q.add(5);
		assertEquals("Peek should return 5", new Integer(5), q.peek());
		assertEquals("Peek should return 5", new Integer(5), q.peek());
		
		q.add(100000);
		assertEquals("Peek should return 100000", new Integer(100000), q.peek());
		assertEquals("Peek should return 100000", new Integer(100000), q.peek());
		
		q.remove();
		assertEquals("Peek should return 100000", new Integer(100000), q.peek());
		assertEquals("Peek should return 100000", new Integer(100000), q.peek());
	}
	
	/**
	 * A method to test the peek functionality of the queue
	 * 
	 * The test cases are are for String values:
	 * 1) Calling peek twice doesn't remove the element from the queue
	 * 2) Peek on an empty queue returns null
	 */
	@Test
	public void testPeekStrings() {
		Queue<String> q = new Queue<String>();
		
		assertNull("Peek on empty queue should return null", q.peek());
		
		q.add("");
		assertEquals("Peek should return empty string", "", q.peek());
		assertEquals("Peek should return empty string", "", q.peek());
		
		q.add("Saman");
		assertEquals("Peek should return \"Saman\"", "Saman", q.peek());
		assertEquals("Peek should return \"Saman\"", "Saman", q.peek());
		
		q.add("Sood");
		assertEquals("Peek should return \"Sood\"", "Sood", q.peek());
		assertEquals("Peek should return \"Sood\"", "Sood", q.peek());
		
		q.remove();
		assertEquals("Peek should return \"Sood\"", "Sood", q.peek());
		assertEquals("Peek should return \"Sood\"", "Sood", q.peek());
	}
	
	/**
	 * A method to test the remove functionality of the queue
	 * 
	 * The test cases are are for Integer values:
	 * 1) Calling removes the element in the queue
	 * 2) Remove on an empty queue returns null
	 */
	@Test
	public void testRemoveIntegers() {
		Queue<Integer> q = new Queue<Integer>();
		
		assertNull("Peek on empty queue should return null", q.remove());
		
		q.add(4);
		assertEquals("Remove should return 4", new Integer(4), q.remove());
		assertEquals("Remove should return null", null, q.remove());
		
		q.add(4);
		q.add(5);
		assertEquals("Remove should return 4", new Integer(4), q.remove());
		assertEquals("Remove should return 5", new Integer(5), q.remove());
		assertEquals("Remove should return null", null, q.remove());
		
		q.add(4);
		q.add(5);
		q.add(100000);
		assertEquals("Remove should return 4", new Integer(4), q.remove());
		assertEquals("Remove should return 5", new Integer(5), q.remove());
		assertEquals("Remove should return 100000", new Integer(100000), q.remove());
		assertEquals("Remove should return null", null, q.remove());
	}
	
	/**
	 * A method to test the remove functionality of the queue
	 * 
	 * The test cases are are for Integer values:
	 * 1) Calling removes the element in the queue
	 * 2) Remove on an empty queue returns null
	 */
	@Test
	public void testRemoveStrings() {
		Queue<String> q = new Queue<String>();
		
		assertNull("Peek on empty queue should return null", q.remove());
		
		q.add("");
		assertEquals("Remove should return empty string", "", q.remove());
		assertEquals("Remove should return null", null, q.remove());
		
		q.add("");
		q.add("Saman");
		assertEquals("Remove should return empty string", "", q.remove());
		assertEquals("Remove should return \"Saman\"", "Saman", q.remove());
		assertEquals("Remove should return null", null, q.remove());
		
		q.add("");
		q.add("Saman");
		q.add("Sood");
		assertEquals("Remove should return empty string", "", q.remove());
		assertEquals("Remove should return \"Saman\"", "Saman", q.remove());
		assertEquals("Remove should return \"Sood\"", "Sood", q.remove());
		assertEquals("Remove should return null", null, q.remove());
	}
}
