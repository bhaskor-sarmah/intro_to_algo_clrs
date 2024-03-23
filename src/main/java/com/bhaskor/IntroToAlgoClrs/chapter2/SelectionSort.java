package com.bhaskor.IntroToAlgoClrs.chapter2;

/**
 * Exercise 2.2-2: Implementing selection sort
 * 
 * @author bhaskor
 */
public class SelectionSort {

	public int[] sortArray(int[] inputArray) {
		
		for(int i=0;i<inputArray.length-1;i++) {
			int smallest = Integer.MAX_VALUE;
			int position = -1;
			for(int j=i;j<inputArray.length;j++) {
				if(inputArray[j] < smallest) {
					smallest = inputArray[j];
					position = j;
				}
			}
			int temp = inputArray[i];
			inputArray[i] = smallest;
			inputArray[position] = temp;
		}
		
		return inputArray;
	}
}
