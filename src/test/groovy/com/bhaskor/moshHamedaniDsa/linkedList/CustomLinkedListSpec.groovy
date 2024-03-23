package com.bhaskor.moshHamedaniDsa.linkedList

import spock.lang.Specification
import spock.lang.Subject

/**
 * Unit tests for {@link CustomLinkedList}
 * 
 * @author bhaskor
 */
class CustomLinkedListSpec extends Specification{
	
	@Subject
	CustomLinkedList customLinkedList
	
	def setup() {
		customLinkedList =  new CustomLinkedList<Integer>();
	}
	
	def "addFirst() when list is empty, should have one node to the linkedList"() {
		given:
		
		when:
		customLinkedList.addFirst(5);
		
		then:
		customLinkedList.first.data == 5
		customLinkedList.last.data == 5
		customLinkedList.size == 1
		
	}
	
	def "addFirst() when list has elements, should add the element to the start of the linkedList"() {
		given:
		customLinkedList.addFirst(15);
		
		when:
		customLinkedList.addFirst(23);
		
		then:
		customLinkedList.first.data == 23
		customLinkedList.last.data == 15
		customLinkedList.size == 2
		
	}
	
	def "addLast() when list is empty, should have one node to the linkedList"() {
		given:
		
		when:
		customLinkedList.addLast(5);
		
		then:
		customLinkedList.first.data == 5
		customLinkedList.last.data == 5
		customLinkedList.size == 1
		
	}
	
	def "addLast() when list has elements, should add the element to the end of the linkedList"() {
		given:
		customLinkedList.addFirst(15);
		customLinkedList.addLast(23);
		
		when:
		customLinkedList.addLast(44);
		
		then:
		customLinkedList.first.data == 15
		customLinkedList.last.data == 44
		customLinkedList.size == 3
		
	}
	
	def "deleteFirst() when list is empty, should return null"() {
		given:
		
		when:
		def deletedEntry = customLinkedList.deleteFirst();
		
		then:
		customLinkedList.size == 0
		deletedEntry == null
		
	}
	
	def "deleteFirst() when list has some data, should delete the first item and return it"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		customLinkedList.addLast(44);
		customLinkedList.addLast(65);
		
		when:
		def deletedEntry = customLinkedList.deleteFirst();
		
		then:
		deletedEntry == 15
		customLinkedList.size == 3
		customLinkedList.first.data == 23
		customLinkedList.last.data == 65
		
	}
	
	def "deleteLast() when list is empty, should return null"() {
		given:
		
		when:
		def deletedEntry = customLinkedList.deleteLast();
		
		then:
		customLinkedList.size == 0
		deletedEntry == null
		
	}
	
	def "deleteLast() when list has some data, should delete the last item and return it"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		customLinkedList.addLast(44);
		customLinkedList.addLast(65);
		
		when:
		def deletedEntry = customLinkedList.deleteLast();
		
		then:
		deletedEntry == 65
		customLinkedList.size == 3
		customLinkedList.first.data == 15
		customLinkedList.last.data == 44
		
	}
	
	def "contains() when list is empty, should return false"() {
		given:
		
		when:
		def result = customLinkedList.contains(24);
		
		then:
		result == false
		
	}
	
	def "contains() when list is not empty but data not found, should return false"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		customLinkedList.addLast(44);
		
		when:
		def result = customLinkedList.contains(24);
		
		then:
		result == false
		
	}
	
	def "contains() when list has the data, should return true"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		customLinkedList.addLast(44);
		customLinkedList.addLast(65);
		customLinkedList.addLast(86);
		
		when: "Searched data is the first item"
		def result = customLinkedList.contains(15);
		
		then:
		result == true
		
		when: "Searched data is in the middle of the list"
		result = customLinkedList.contains(44);
		
		then:
		result == true
		
		when: "Searched data is at the last of the list"
		result = customLinkedList.contains(86);
		
		then:
		result == true
	}
	
	def "indexOf() when list is empty, should return -1"() {
		given:
		
		when:
		def result = customLinkedList.indexOf(24);
		
		then:
		result == -1
		
	}
	
	def "indexOf() when list is not empty but data not found, should return -1"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		customLinkedList.addLast(44);
		
		when:
		def result = customLinkedList.indexOf(24);
		
		then:
		result == -1
		
	}
	
	def "indexOf() when list has the data, should return the index of the data"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		customLinkedList.addLast(44);
		customLinkedList.addLast(65);
		customLinkedList.addLast(86);
		
		when: "Searched data is the first item"
		def result = customLinkedList.indexOf(15);
		
		then:
		result == 0
		
		when: "Searched data is in the middle of the list"
		result = customLinkedList.indexOf(44);
		
		then:
		result == 2
		
		when: "Searched data is at the last of the list"
		result = customLinkedList.indexOf(86);
		
		then:
		result == 4
	}
}
