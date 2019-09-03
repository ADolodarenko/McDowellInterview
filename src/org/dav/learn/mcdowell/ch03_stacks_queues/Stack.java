package org.dav.learn.mcdowell.ch03_stacks_queues;

public class Stack<T> {
	Node<T> top;
	int capacity;
	int size;

	public Stack() {
		capacity = 10;
	}

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	boolean isEmpty() {
		return top == null;
	}

	T pop() {
		if (top != null) {
			T item = top.data;
			top = top.next;
			size--;
			return item;
		}
		return null;
	}

	void push(T item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
		size++;
	}

	T peek() {
		if (top != null)
			return top.data;
		else
			return null;
	}

	public boolean isFull() {
		if (capacity > 0)
			return size >= capacity;
		else
			return false;
	}
}
