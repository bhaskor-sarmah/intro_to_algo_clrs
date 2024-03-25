package com.bhaskor.moshHamedaniDsa.array

import spock.lang.Specification
import spock.lang.Subject

/**
 * Unit test for {@link DynamicArray}
 * 
 * @author bhaskor
 */
class DynamicArraySpec  extends Specification{
	
	@Subject
	DynamicArray<Integer> dynamicArray;
	
	def dynamicArrayInitialSize = 3
	
	def setup() {
		dynamicArray = new DynamicArray<>(dynamicArrayInitialSize)
	}
	
	def "Insert two elements in the array should insert successfully"() {
		given:
		
		when:
		dynamicArray.insert(5)
		dynamicArray.insert(3)		
		
		then:
		dynamicArray.size() == 2
		dynamicArray.getItems()[0] == 5
		dynamicArray.getItems()[1] == 3
	}
	
	def "Insert multiple elements in the array which will resize the array"() {
		given:
		
		when:
		dynamicArray.insert(15)
		dynamicArray.insert(35)
		dynamicArray.insert(46)
		dynamicArray.insert(33)
		dynamicArray.insert(95)
		dynamicArray.insert(20)
		dynamicArray.insert(54)
		dynamicArray.insert(78)
		dynamicArray.insert(16)
		
		then:
		dynamicArray.size() == 9
		dynamicArray.getItems()[0] == 15
		dynamicArray.getItems()[1] == 35
		dynamicArray.getItems()[2] == 46
		dynamicArray.getItems()[3] == 33
		dynamicArray.getItems()[4] == 95
		dynamicArray.getItems()[5] == 20
		dynamicArray.getItems()[6] == 54
		dynamicArray.getItems()[7] == 78
		dynamicArray.getItems()[8] == 16
	}
	
	def "Delete one elements from the array using index should delete the element"() {
		given:
		dynamicArray.insert(5)
		dynamicArray.insert(3)
		dynamicArray.insert(10)
		
		when:
		dynamicArray.removeAt(1)
		
		then:
		dynamicArray.size() == 2
		dynamicArray.getItems()[0] == 5
		dynamicArray.getItems()[1] == 10
	}
	
	def "Delete elements from the array using index when index doesn't exist shout throw IndexOutOfBoundsException"() {
		given:
		dynamicArray.insert(5)
		dynamicArray.insert(3)
		dynamicArray.insert(10)
		
		when:
		dynamicArray.removeAt(7)
		
		then:
		thrown IndexOutOfBoundsException
		
		when:
		dynamicArray.removeAt(-1)
		
		then:
		thrown IndexOutOfBoundsException
	}
	
	
	def "Calling indexOf when data available in the array should return the index"() {
		given:
		dynamicArray.insert(75)
		dynamicArray.insert(23)
		dynamicArray.insert(10)
		dynamicArray.insert(33)
		dynamicArray.insert(95)
		dynamicArray.insert(20)
		dynamicArray.insert(54)
		dynamicArray.insert(78)
		dynamicArray.insert(16)
		
		when:
		def indexOfElement = dynamicArray.indexOf(54)
		
		then:
		indexOfElement == 6
	}
	
	def "Calling indexOf when data is not available in the array should return -1"() {
		given:
		dynamicArray.insert(75)
		dynamicArray.insert(23)
		dynamicArray.insert(10)
		dynamicArray.insert(33)
		dynamicArray.insert(95)
		dynamicArray.insert(20)
		dynamicArray.insert(54)
		dynamicArray.insert(78)
		dynamicArray.insert(16)
		
		when:
		def indexOfElement = dynamicArray.indexOf(88)
		
		then:
		indexOfElement == -1
	}
	
}
