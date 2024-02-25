package com.bhaskor.IntroToAlgoClrs.chapter2;

/**
 * InsertionSort implementation defined in Section 2.1
 * 
 * @author bhaskor
 */
public class InsertionSort {
	public int[] sortArray(int array[]) {

		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && key < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}

		return array;
	}
}
