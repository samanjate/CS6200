package com.neu.msd;

import java.util.List;
import java.util.Scanner; 
/**
 * Class to print the numbers of the list.
 * 
 * @author Samanjate Sood
 *
 */
public class Printer {

	/**
	 * 
	 * @param args
	 * 
	 * Starting point of the application. Asks for the user to input two numbers
	 * and calls the implementation of the Range.getRange() method.
	 * 
	 * Prints the list returned by the function.
	 */
	public static void main(String[] args) {
		
		System.out.print("Enter the first number: ");
		Scanner scan = new Scanner(System.in);
		String arg1 = scan.next();
		System.out.print("Enter the first number: ");
		String arg2 = scan.next();
		System.out.println();
		try {
			
			int num1 = Integer.parseInt(arg1);
			int num2 = Integer.parseInt(arg2);
			Range range = new RangeImp();
			List<Integer> nums = range.getRange(num1, num2);
			if(nums != null) {
				for(Integer num : nums) {
					System.out.print(num + " ");
				}
			}
			
		} catch(NumberFormatException ex) {
			System.out.println("Please enter valid interger values only!");
		} finally {
			scan.close();
		}
	}

}
