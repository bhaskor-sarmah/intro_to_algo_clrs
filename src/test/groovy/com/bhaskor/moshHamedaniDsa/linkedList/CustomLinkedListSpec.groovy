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
		customLinkedList.size() == 1
		
	}
	
	def "addFirst() when list has elements, should add the element to the start of the linkedList"() {
		given:
		customLinkedList.addFirst(15);
		
		when:
		customLinkedList.addFirst(23);
		
		then:
		customLinkedList.first.data == 23
		customLinkedList.last.data == 15
		customLinkedList.size() == 2
		
	}
	
	def "addLast() when list is empty, should have one node to the linkedList"() {
		given:
		
		when:
		customLinkedList.addLast(5);
		
		then:
		customLinkedList.first.data == 5
		customLinkedList.last.data == 5
		customLinkedList.size() == 1
		
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
		customLinkedList.size() == 3
		
	}
	
	def "deleteFirst() when list is empty, should throw NoSuchElementException"() {
		given:
		
		when:
		def deletedEntry = customLinkedList.deleteFirst();
		
		then:
		customLinkedList.size() == 0
		thrown NoSuchElementException
		
	}
	
	def "deleteFirst() when list has one item, should delete the item to make the list empty"() {
		given:
		customLinkedList.addLast(15);
		
		when:
		def deletedEntry = customLinkedList.deleteFirst();
		
		then:
		customLinkedList.size() == 0
		customLinkedList.first == null
		customLinkedList.last == null
		
	}
	
	def "deleteFirst() when list has two items, should delete the first item and return it"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		
		when:
		def deletedEntry = customLinkedList.deleteFirst();
		
		then:
		deletedEntry == 15
		customLinkedList.size() == 1
		customLinkedList.first.data == 23
		customLinkedList.last.data == 23
		
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
		customLinkedList.size() == 3
		customLinkedList.first.data == 23
		customLinkedList.last.data == 65
		
	}
	
	def "deleteLast() when list is empty, should throw NoSuchElementException"() {
		given:
		
		when:
		def deletedEntry = customLinkedList.deleteLast();
		
		then:
		customLinkedList.size() == 0
		thrown NoSuchElementException
		
	}
	
	def "deleteLast() when list has one item, should delete the item to make the list empty"() {
		given:
		customLinkedList.addLast(15);
		
		when:
		def deletedEntry = customLinkedList.deleteLast();
		
		then:
		customLinkedList.size() == 0
		customLinkedList.first == null
		customLinkedList.last == null
		
	}
	
	def "deleteLast() when list has two items, should delete the last item and return it"() {
		given:
		customLinkedList.addLast(15);
		customLinkedList.addLast(23);
		
		when:
		def deletedEntry = customLinkedList.deleteLast();
		
		then:
		deletedEntry == 23
		customLinkedList.size() == 1
		customLinkedList.first.data == 15
		customLinkedList.last.data == 15
		
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
		customLinkedList.size() == 3
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
	
	def "contains() when list has some data, should return true"() {
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
	
	def "indexOf() when list has some data, should return the index of the data"() {
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
	
	def "toArray() when the list is empty, shoud return an empty array"() {
		given:
		
		when: "Searched data is the first item"
		def result = customLinkedList.toArray();
		
		then:
		result == []
	}
	
	def "toArray() when list has some data, should return an array containing the data"() {
		given:
		customLinkedList.addLast(15);
		
		when: "The list has only one item"
		def result = customLinkedList.toArray();
		
		then:
		result == [15]
		
		when: "The list has multiple items"
		customLinkedList.addLast(83);
		customLinkedList.addLast(57);
		result = customLinkedList.toArray();
		
		then:
		result == [15, 83, 57]
	}
	
	def "reverse() when list has no data or one data, should do nothing"() {
		given:
		
		when: "List has not data"
		customLinkedList.reverse();
		
		then:
		customLinkedList.size() == 0
		customLinkedList.toArray() == []
		
		when: "List has one element"
		customLinkedList.addLast(15);
		customLinkedList.reverse();
		
		then:
		customLinkedList.size() == 1
		customLinkedList.toArray() == [15]
	}
	
	def "reverse() when list has two or more items, should reverse the list"() {
		given:
		customLinkedList.addLast(83);
		customLinkedList.addLast(57);
		
		when: "List has two items"
		customLinkedList.reverse();
		
		then:
		customLinkedList.size() == 2
		customLinkedList.toArray() == [57, 83]
		
		when: "List has more than 2 elements"
		customLinkedList.addLast(15);
		customLinkedList.addLast(24);
		customLinkedList.addLast(66);
		customLinkedList.reverse();
		
		then:
		customLinkedList.size() == 5
		customLinkedList.toArray() == [66, 24, 15, 83, 57]
	}
	
	def "findKthFromTheEnd() when invalid input for K, should throw RuntineException"() {
		given:
		
		when: "List is empty"
		def result = customLinkedList.findKthFromTheEnd(2);
		
		then:
		thrown IllegalStateException
		
		when: "K is greate than list size"
		customLinkedList.addLast(15);
		customLinkedList.addLast(24);
		result = customLinkedList.findKthFromTheEnd(3);
		
		then:
		thrown IllegalArgumentException
	}
	
	def "findKthFromTheEnd() when list has items, should return the Kth item from the last"() {
		given:
		customLinkedList.addLast(83);
		
		when: "List has one item"
		def result = customLinkedList.findKthFromTheEnd(1);
		
		then:
		result.data == 83;
		
		when: "List has two items"
		customLinkedList.addLast(57);
		result = customLinkedList.findKthFromTheEnd(2);
		
		then:
		result.data == 83;
		
		when: "List has more than two items"
		customLinkedList.addLast(57);
		customLinkedList.addLast(15);
		customLinkedList.addLast(24);
		customLinkedList.addLast(66);
		result = customLinkedList.findKthFromTheEnd(3);
		
		then:
		result.data == 15;
	}
}
