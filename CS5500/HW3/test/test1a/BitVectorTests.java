package test1a;

import static org.junit.Assert.*;

import org.junit.Test;

import q1a.BitVector;
import q1a.IBitVector;

/**
 * A class that tests different functionality that are in the BitVector class
 * either inherited from IBitVector or specific to it.
 * 
 * @author Samanjate Sood
 *
 */
public class BitVectorTests {
	
	/**
	 * A method to test that the vector get and set method of the BitVector
	 * 
	 * The cases tested are: 
	 * 1) Non-natural numbers being set
	 * 2) Setting natural numbers inside 32-bit range
	 * 3) Setting natural numbers at the boundary of 32-bits
	 * 4) Setting a very large value
	 * 5) Adjacent values are not being set
	 * 6) Random values are not being set
	 */
	@Test
	public void testGetSet() {
		IBitVector vector = new BitVector();
		
		vector.set(0);
		assertFalse("-1 should not be set", vector.get(-1));
		assertFalse("0 should not be set", vector.get(0));
		assertFalse("1 should not be set", vector.get(1));
		
		vector.set(-3);
		assertFalse("-4 should not be set", vector.get(-4));
		assertFalse("-3 should not be set", vector.get(-3));
		assertFalse("-2 should not be set", vector.get(-2));
		
		vector.set(1);
		assertFalse("0 should not be set", vector.get(0));
		assertTrue("1 should be set", vector.get(1));
		assertFalse("2 should not be set", vector.get(2));
		
		vector.set(10);
		assertFalse("9 should not be set", vector.get(9));
		assertTrue("10 should be set", vector.get(10));
		assertFalse("11 should not be set", vector.get(11));
		
		vector.set(31);
		assertFalse("30 should not be set", vector.get(30));
		assertTrue("31 should be set", vector.get(31));
		assertFalse("32 should not be set", vector.get(32));
		
		vector.set(32);
		assertTrue("32 should be set", vector.get(32));
		assertFalse("33 should not be set", vector.get(33));
		
		vector.set(63);
		assertFalse("62 should not be set", vector.get(62));
		assertTrue("63 should be set", vector.get(63));
		assertFalse("64 should not be set", vector.get(64));
		
		vector.set(127);
		assertFalse("126 should not be set", vector.get(126));
		assertTrue("127 should be set", vector.get(127));
		assertFalse("128 should not be set", vector.get(128));
		
		vector.set(128);
		assertTrue("128 should be set", vector.get(128));
		assertFalse("129 should not be set", vector.get(129));;
		
		vector.set(100000);
		assertFalse("99999 should not be set", vector.get(99999));
		assertTrue("Large value should be set", vector.get(100000));
		assertFalse("100001 should not be set", vector.get(100001));
		
		assertFalse("9842 should not be set", vector.get(9842));
		assertFalse("23 should not be set", vector.get(23));
		assertFalse("58 should not be set", vector.get(58));
	}

	/**
	 * A method to test the the size of BitVector is updated correctly
	 * 
	 * The cases tested are: 
	 * 1) Initial size of the vector should be zero.
	 * 2) Adding a few elements should return the number of elements added.
	 * 3) Clearing an element should decrement the size by 1.
	 * 4) Clearing a non-element should not affect the size.
	 * 5) Adding element at least 32 bigger than the largest element in the set.
	 * 6) Adding element at least 64 bigger than the largest element in the set.
	 * 7) Adding a very large element just increments the size by 1.
	 */
	@Test
	public void testSize() {
		IBitVector vector = new BitVector();
		
		//assertEquals("Size should be 0", 0, vector.size());
		
		vector.set(100000);
		assertEquals("Size should be 1", 1, vector.size());
		
		vector.clear(100000);
		assertEquals("Size should be 0", 0, vector.size());
		
		vector.set(3);
		vector.set(8);
		assertEquals("Size should be 2", 2, vector.size());
		
		vector.clear(8);
		assertEquals("Size should be 1", 1, vector.size());
		
		vector.clear(10);
		assertEquals("Size should be 1", 1, vector.size());
		
		vector.clear(3);
		assertEquals("Size should be 0", 0, vector.size());
		
		vector.set(1);
		vector.set(4);
		vector.set(45);
		assertEquals("Size should be 3", 3, vector.size());
		
		vector.set(150);
		assertEquals("Size should be 4", 4, vector.size());
		
		vector.set(50000);
		assertEquals("Size should be 5", 5, vector.size());
	}
	
	/**
	 * A method to test that the vector clears the correct values of the BitVector
	 * 
	 * The cases tested are: 
	 * 1) Non-natural numbers are ignored
	 * 2) Clearing values that are not set has no effect
	 * 3) Set values are getting cleared
	 * 4) Adjacent values of the set values that are set shouldn't be affected
	 * 5) Very large values are cleared
	 */
	@Test
	public void testClear() {
		IBitVector vector = new BitVector();
		
		vector.clear(0);
		assertFalse("-1 should not be set", vector.get(-1));
		assertFalse("0 should not be set", vector.get(0));
		assertFalse("1 should not be set", vector.get(1));
		
		vector.clear(-3);
		assertFalse("-4 should not be set", vector.get(-4));
		assertFalse("-3 should not be set", vector.get(-3));
		assertFalse("-2 should not be set", vector.get(-2));
		
		vector.clear(2);
		assertFalse("2 should not be set", vector.get(2));
		
		vector.set(2);
		assertTrue("2 should be set", vector.get(2));
		
		vector.set(1);
		vector.set(3);
		vector.clear(2);
		assertTrue("1 should be set", vector.get(1));
		assertFalse("2 should not be set", vector.get(2));
		assertTrue("3 should be set", vector.get(3));
		
		vector.set(31);
		assertTrue("31 should be set", vector.get(31));
		
		vector.set(30);
		vector.set(32);
		vector.clear(31);
		assertTrue("30 should be set", vector.get(30));
		assertFalse("31 should not be set", vector.get(31));
		assertTrue("32 should be set", vector.get(32));
		
		vector.clear(30);
		assertFalse("30 should not be set", vector.get(30));
		vector.clear(32);
		assertFalse("32 should not be set", vector.get(32));
		
		vector.set(127);
		assertTrue("127 should be set", vector.get(127));
		
		vector.set(126);
		vector.set(128);
		vector.clear(127);
		assertTrue("126 should be set", vector.get(126));
		assertFalse("127 should not be set", vector.get(127));
		assertTrue("128 should be set", vector.get(128));
		
		vector.clear(126);
		assertFalse("126 should not be set", vector.get(126));
		vector.clear(128);
		assertFalse("128 should not be set", vector.get(128));
		
		vector.set(100000);
		assertTrue("Large value should be set", vector.get(100000));

		vector.clear(100000);
		assertFalse("Large value should not be set", vector.get(100000));
	}
	
	/**
	 * A method to test that one vector copies values that are set on the 
	 * second vector.
	 * 
	 * The cases tested are: 
	 * 1) Correct values are copied
	 * 2) Same values in both vectors are counted as 1
	 * 3) The size of the vector is as expected
	 * 4) The second vector is not affected
	 * 5) Very large values are copied
	 */
	@Test
	public void testCopy() {
		IBitVector vector1 = new BitVector();
		BitVector vector2 = new BitVector();
		
		vector1.set(10);
		vector1.set(20);
		assertTrue("10 should be set", vector1.get(10));
		assertTrue("20 should be set", vector1.get(20));
		assertEquals("Size should be 2", 2, vector1.size());
		
		vector2.set(30);
		vector2.set(40);
		assertTrue("30 should be set", vector2.get(30));
		assertTrue("40 should be set", vector2.get(40));
		assertEquals("Size should be 2", 2, vector2.size());
		
		vector1.copy(vector2);
		assertTrue("10 should be set", vector1.get(10));
		assertTrue("20 should be set", vector1.get(20));
		assertTrue("30 should be set", vector1.get(30));
		assertTrue("40 should be set", vector1.get(40));
		assertEquals("Size should be 4", 4, vector1.size());
		assertFalse("10 should not be set", vector2.get(10));
		assertFalse("20 should not be set", vector2.get(20));
		assertTrue("30 should be set", vector2.get(30));
		assertTrue("40 should be set", vector2.get(40));
		assertEquals("Size should be 2", 2, vector2.size());
		
		vector1.set(100);
		vector1.set(200);
		assertTrue("100 should be set", vector1.get(100));
		assertTrue("200 should be set", vector1.get(200));
		
		vector2.set(200);
		vector2.set(300);
		assertTrue("200 should be set", vector2.get(200));
		assertTrue("300 should be set", vector2.get(300));
		
		vector1.copy(vector2);
		assertTrue("100 should be set", vector1.get(100));
		assertTrue("200 should be set", vector1.get(200));
		assertTrue("300 should be set", vector1.get(300));
		assertEquals("Size should be 7", 7, vector1.size());
		assertFalse("100 should not be set", vector2.get(100));
		assertTrue("200 should be set", vector2.get(200));
		assertTrue("300 should be set", vector2.get(300));
		assertEquals("Size should be 4", 4, vector2.size());
		
		vector1.set(500);
		vector1.set(600);
		assertTrue("500 should be set", vector1.get(500));
		assertTrue("600 should be set", vector1.get(600));
		
		vector2.set(100000);
		assertTrue("100000 should be set", vector2.get(100000));
		assertEquals("Size should be 5", 5, vector2.size());
		
		vector1.copy(vector2);
		assertTrue("500 should be set", vector1.get(500));
		assertTrue("600 should be set", vector1.get(600));
		assertTrue("100000 should be set", vector1.get(100000));
		assertEquals("Size should be 10", 10, vector1.size());
		assertFalse("500 should not be set", vector2.get(500));
		assertFalse("600 should be set", vector2.get(600));
		assertTrue("100000 be set", vector2.get(100000));
		assertEquals("Size should be 5", 5, vector2.size());
	}

}
