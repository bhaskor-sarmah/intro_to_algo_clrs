package com.bhaskor.IntroToAlgoClrs.chapter2;

/**
 * Exercise 2.1-4: Adding binary integers present in two array in binary form
 * and store the sum in a third array
 * 
 * @author bhaskor
 */
public class AddBinaryIntegers {

	public int[] addBinaryInteger(int[] firstBinaryNumber, int[] secondBinaryNumber) {
		
		int[] result = new int[firstBinaryNumber.length + 1];

		int carry = 0;

		for (int i = firstBinaryNumber.length - 1; i >= 0; i--) {
			
			int sum = firstBinaryNumber[i] + secondBinaryNumber[i] + carry;

			carry = sum / 2;

			result[i + 1] = sum % 2;
		}

		result[0] = carry;

		return result;
	}
}
