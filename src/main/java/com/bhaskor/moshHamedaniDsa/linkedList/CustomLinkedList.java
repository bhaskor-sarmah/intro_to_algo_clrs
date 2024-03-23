package com.bhaskor.moshHamedaniDsa.linkedList;

import java.util.NoSuchElementException;

/**
 * Exercise: Building an implementation of linked list.
 * 
 * <p>
 * Methods to be created
 * <code>addFirst() addLast() deleteFirst() deleteLast() contains() indexOf</code>
 * 
 * @author bhaskor
 */
public class CustomLinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;

	public void addFirst(T data) {
		final Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			addFirstItemWhenListIsEmpty(newNode);
			return;
		}
		newNode.next = first;
		first = newNode;
		size++;
	}

	public void addLast(T data) {
		final Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			addFirstItemWhenListIsEmpty(newNode);
			return;
		}
		last.next = newNode;
		last = newNode;
		size++;
	}

	public T deleteFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		if(first == last) {
			T currentFirstNodeData = first.data;
			first = last = null;
			size--;
			return currentFirstNodeData;
		}

		T currentFirstNodeData = first.data;
		Node<T> nextNodeOfFirstNode = first.next;

		first.next = null;

		first = nextNodeOfFirstNode;

		size--;

		return currentFirstNodeData;
	}

	public T deleteLast() {
		if (isEmpty())
			throw new NoSuchElementException();

		if(first == last) {
			T currentFirstNodeData = first.data;
			first = last = null;
			size--;
			return currentFirstNodeData;
		}
		
		Node<T> currentNode = first;
		Node<T> nextNode = first.next;

		while (nextNode.next != null) {
			currentNode = currentNode.next;
			nextNode = nextNode.next;
		}

		currentNode.next = null;
		last = currentNode;
		size--;

		return nextNode.data;
	}

	public boolean contains(T data) {
		return indexOf(data) != -1;
	}

	public int indexOf(T data) {
		int index = 0;
		Node<T> currentNode = first;

		while (currentNode != null) {
			if (currentNode.data.equals(data))
				return index;

			currentNode = currentNode.next;
			index++;
		}

		return -1;
	}
	
	private boolean isEmpty() {
		return first == null;
	}

	private void addFirstItemWhenListIsEmpty(final Node<T> newNode) {
		first = newNode;
		last = newNode;
		size = 1;
	}

	private static class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

}
