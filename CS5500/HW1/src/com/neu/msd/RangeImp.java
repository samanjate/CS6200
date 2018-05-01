package com.neu.msd;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Range Interface.
 *
 * @author Samanjate Sood
 *
 */
public class RangeImp implements Range {

	/**
	 * Implementation of the getRange() function.
	 *
	 * @param num1
	 * @param num2
	 *
	 * @return A list of numbers that fall between num1 and num2, excluding the two.
	 */
	@Override
	public List<Integer> getRange(int num1, int num2) {
		if(num2 < num1) {
			int temp = num2;
			num2 = num1;
			num1 = temp;
		}
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = num1 + 1; i < num2; i++) {
			if(i % 2 != 0) {
				nums.add(i);
			}
		}
		return nums;
	}
}
