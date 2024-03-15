package com.bhaskor.IntroToAlgoClrs.chapter2

import spock.lang.Specification
import spock.lang.Subject

/**
 * Unit test for {@link MergeSort}
 *
 * @author bhaskor
 */
class MergeSortSpec extends Specification{
	
	@Subject
	MergeSort mergeSort;
	
	def setup() {
		mergeSort = new MergeSort();
	}
	
	def "test sortArray() with unsorted array"() {
		given:
			int[] initialArray = [41, 5, 69, 23, 99, 25, 43, 88]
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == [5, 23, 25, 41, 43, 69, 88, 99]
	}
	
	
	def "test sortArray() with blank array"() {
		given:
			int[] initialArray = []
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == []
	}
	
	
	def "test sortArray() with a sorted array"() {
		given:
			int[] initialArray = [5, 23, 25, 41, 43, 69, 88, 99]
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == [5, 23, 25, 41, 43, 69, 88, 99]
	}
	
	
	def "test sortArray() with one element in array"() {
		given:
			int[] initialArray = [99]
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == [99]
	}
	
	def "test sortArray() with two element in array"() {
		given:
			int[] initialArray = [674, 235]
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == [235, 674]
	}
	
	def "test sortArray() with odd number of total elements"() {
		given:
			int[] initialArray = [863, 786, 237, 96, 876, 345, 389, 650, 190]
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == [96, 190, 237, 345, 389, 650, 786, 863, 876]
	}
	
	def "test sortArray() with even number of total elements"() {
		given:
			int[] initialArray = [863, 786, 237, 96, 876, 345, 650, 190]
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == [96, 190, 237, 345, 650, 786, 863, 876]
	}
	
	def "test sortArray() with duplicate element in the array"() {
		given:
			int[] initialArray = [41, 5, 5, 69, 23, 99, 23, 25, 43, 69, 88]
		when:
			def result = mergeSort.sortArray(initialArray);
		then:
			result == [5, 5, 23, 23, 25, 41, 43, 69, 69, 88, 99]
	}
}
