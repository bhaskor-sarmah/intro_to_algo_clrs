package com.bhaskor.IntroToAlgoClrs.chapter2;

/**
 * Merge sort implementation defined in Section 2.3.1
 * 
 * @author bhaskor
 */
public class MergeSort {

	public int[] sortArray(int arr[]) {
		mergeSort(arr, 0, arr.length - 1);
		return arr;
	}

	private void mergeSort(int[] arr, int firstIndex, int lastIndex) {
		if (firstIndex >= lastIndex) {
			return;
		}

		int mid = (firstIndex + lastIndex) / 2;

		mergeSort(arr, firstIndex, mid);
		mergeSort(arr, mid + 1, lastIndex);

		merge(arr, firstIndex, mid, lastIndex);
	}

	private void merge(int arr[], int left, int mid, int right) {
		int leftArray[] = new int[mid - left + 1];
		int rightArray[] = new int[right - mid];

		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = arr[left + i];
		}
		
		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = arr[mid + i + 1];
		}

		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int mainArrayIndex = left;

		while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
			if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
				arr[mainArrayIndex] = leftArray[leftArrayIndex];
				mainArrayIndex++;
				leftArrayIndex++;
			} else {
				arr[mainArrayIndex] = rightArray[rightArrayIndex];
				mainArrayIndex++;
				rightArrayIndex++;
			}
		}

		while (leftArrayIndex < leftArray.length) {
			arr[mainArrayIndex] = leftArray[leftArrayIndex];
			mainArrayIndex++;
			leftArrayIndex++;
		}

		while (rightArrayIndex < rightArray.length) {
			arr[mainArrayIndex] = rightArray[rightArrayIndex];
			mainArrayIndex++;
			rightArrayIndex++;
		}
	}

}
