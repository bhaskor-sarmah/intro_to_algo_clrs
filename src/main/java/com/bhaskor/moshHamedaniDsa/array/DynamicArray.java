package com.bhaskor.moshHamedaniDsa.array;

/**
 * <p>
 * Exercise: Building an Dynamic Array Array should automatically grow when
 * adding items and it should automatically shrink when removing items
 * 
 * <p>
 * Methods to be created <code>insert() removeAt() size() indexOf() getItems()</code>
 * 
 * @author bhaskor
 */
public class DynamicArray {

	private int arraySize;
	private int[] internalArray;
	private int noOfElement = 0;

	DynamicArray(final int initialSize) {
		arraySize = initialSize;
		internalArray = new int[arraySize];
	}

	public void insert(final int element) {
		if (noOfElement >= arraySize) {
			resizeArray();
		}
		internalArray[noOfElement++] = element;
	}

	public void removeAt(int index) {
		if (index < 0 || index >= noOfElement) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = index; i < noOfElement - 1; i++) {
			internalArray[i] = internalArray[i + 1];
		}
		noOfElement--;
	}

	public int indexOf(int element) {
		for (int i = 0; i < noOfElement; i++) {
			if (internalArray[i] == element)
				return i;
		}
		return -1;
	}

	public int size() {
		return noOfElement;
	}
	
	public int[] getItems() {
		final int[] resultArray = new int[noOfElement+1];
		
		copyArrayDataIntoNewArray(resultArray);
		
		return resultArray;
	}

	private void resizeArray() {
		// Growing the Array size by 50% of original size
		arraySize *= 1.5;
		int[] newArray = new int[(int) (arraySize)];

		copyArrayDataIntoNewArray(newArray);

		internalArray = newArray;
	}

	private void copyArrayDataIntoNewArray(int[] newArray) {
		for (int i = 0; i < noOfElement; i++) {
			newArray[i] = internalArray[i];
		}
	}

}
