package com.bhaskor.moshHamedaniDsa.linkedList;

import java.util.NoSuchElementException;

/**
 * Exercise: Building an implementation of linked list.
 * 
 * <p>
 * Methods to be created <code>addFirst() addLast() deleteFirst() deleteLast()
 *  contains() indexOf() size() toArray() reverse()</code>
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

		if (listHasOneEntry()) {
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

		if (listHasOneEntry()) {
			T currentFirstNodeData = first.data;
			first = last = null;
			size--;
			return currentFirstNodeData;
		}

		T currentLastNodeData = last.data;

		Node<T> previousToLastNode = getPrevious(last);

		previousToLastNode.next = null;
		last = previousToLastNode;

		size--;

		return currentLastNodeData;
	}

	private Node<T> getPrevious(Node<T> item) {
		Node<T> current = first;
		while (current.next != null) {
			if (current.next == item)
				return current;

			current = current.next;
		}

		return null;
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

	public int size() {
		return size;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		final T[] array = (T[]) new Object[size];

		int index = 0;

		Node<T> current = first;

		while (current != null) {
			array[index++] = current.data;
			current = current.next;
		}

		return array;
	}

	public void reverse() {
		if(isEmpty()) {
			return;
		}
		
		Node<T> previous = first;
		Node<T> current = first.next;
		
		while(current != null) {
			Node<T> next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		last = first;
		last.next = null;
		first = previous;
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

	private boolean listHasOneEntry() {
		return first == last;
	}

}
