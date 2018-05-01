package com.neu.msd;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 *
 * To test different classes implementing the Range Interface
 *
 * @author Samanjate Sood
 *
 */
public class TestRange {

	/**
	 *
	 * Consists of a mix of function testing for all possible scenarios
	 */
	@Test
	public void testRangeImp() {
		validateRange(32, 96);
		validateRange(64, 21);
		validateRange(0, 44);
		validateRange(33, 33);
		validateRange(0, 0);
		validateRange(0, -3);
		validateRange(-22, -22);
		validateRange(-54, 63);
		validateRange(-54, -22);
		validateRange(-14, -22);
	}

	/**
	 * Helper function for testRangeImp()
	 *
	 * Validates that the list returned by the function false in the range
	 *  of the given numbers
	 */
	private void validateRange(int num1, int num2) {
		Range range = new RangeImp();
		List<Integer> output1 = range.getRange(num1, num2);
		if(num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		Set<Integer> expectedNumbers = new HashSet<Integer>();
		for(int i = num1 + 1; i < num2; i++) {
			if(i % 2 != 0) {
				expectedNumbers.add(i);
			}
		}
		int expectedListSize = expectedNumbers.size();
	    assertNotNull(output1);
		assertEquals("The size of the list returned is incorrect",
				     output1.size(),
				     expectedListSize);
		for(Integer i : output1) {
			assertTrue("The list either has a duplicate value or an unexpected value",
						expectedNumbers.remove(i));
			assertTrue("The list contains number outside the given range", i > num1);
			assertTrue("The list contains number outside the given range", i < num2);
			assertTrue("The number is even", i % 2 != 0);
		}

		assertTrue("The list doesnot contain all the expected values", expectedNumbers.isEmpty());
	}

}
