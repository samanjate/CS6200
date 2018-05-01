package com.neu.msd;

import java.util.List;

/**
 * The interface contains functions that returns a list of numbers
 *  
 * @author Samanjate Sood
 *
 */
public interface Range {

	/**
	 * Gets the range of numbers between the given parameters satisfying 
	 * a condition.
	 * 
	 * @param num1
	 * @param num2
	 * 
	 * @return A list of numbers.
	 */
	public List<Integer> getRange(int num1, int num2);
}
