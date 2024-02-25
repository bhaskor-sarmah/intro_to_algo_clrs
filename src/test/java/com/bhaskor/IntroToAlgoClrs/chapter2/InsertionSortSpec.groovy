package com.bhaskor.IntroToAlgoClrs.chapter2

import spock.lang.Specification
import spock.lang.Subject

/**
 * Unit test for {@link InsertionSort}
 * 
 * @author bhaskor
 */
class InsertionSortSpec extends Specification {
	
	@Subject
	InsertionSort insertionSort;
	
	def setup() {
		insertionSort = new InsertionSort();
	}
	
	def "test sortArray() with unsorted array"() {
		given:
			int[] initialArray = [41, 5, 69, 23, 99, 25, 43, 88]
		when:
			def result = insertionSort.sortArray(initialArray);
		then:
			result == [5, 23, 25, 41, 43, 69, 88, 99]
	}
	
	
	def "test sortArray() with blank array"() {
		given:
			int[] initialArray = []
		when:
			def result = insertionSort.sortArray(initialArray);
		then:
			result == []
	}
	
	
	def "test sortArray() with a sorted array"() {
		given:
			int[] initialArray = [5, 23, 25, 41, 43, 69, 88, 99]
		when:
			def result = insertionSort.sortArray(initialArray);
		then:
			result == [5, 23, 25, 41, 43, 69, 88, 99]
	}
	
	
	def "test sortArray() with one element in array"() {
		given:
			int[] initialArray = [99]
		when:
			def result = insertionSort.sortArray(initialArray);
		then:
			result == [99]
	}
	
	
	def "test sortArray() with duplicate element in the array"() {
		given:
			int[] initialArray = [41, 5, 5, 69, 23, 99, 23, 25, 43, 69, 88]
		when:
			def result = insertionSort.sortArray(initialArray);
		then:
			result == [5, 5, 23, 23, 25, 41, 43, 69, 69, 88, 99]
	}
	
}
