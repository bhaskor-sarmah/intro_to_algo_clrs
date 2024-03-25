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
public class DynamicArray<T> {

	private int arraySize;
	private T[] internalArray;
	private int noOfElement = 0;

	@SuppressWarnings("unchecked")
	DynamicArray(final int initialSize) {
		arraySize = initialSize;
		internalArray = (T[]) new Object[arraySize];
	}

	public void insert(final T element) {
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

	public int indexOf(T element) {
		for (int i = 0; i < noOfElement; i++) {
			if (internalArray[i] == element)
				return i;
		}
		return -1;
	}

	public int size() {
		return noOfElement;
	}
	
	public T[] getItems() {
		@SuppressWarnings("unchecked")
		final T[] resultArray = (T[]) new Object[noOfElement+1];
		
		copyArrayDataIntoNewArray(resultArray);
		
		return resultArray;
	}

	private void resizeArray() {
		// Growing the Array size by 50% of original size
		arraySize *= 1.5;
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[(int) (arraySize)];

		copyArrayDataIntoNewArray(newArray);

		internalArray = newArray;
	}

	private void copyArrayDataIntoNewArray(T[] newArray) {
		for (int i = 0; i < noOfElement; i++) {
			newArray[i] = internalArray[i];
		}
	}

}
