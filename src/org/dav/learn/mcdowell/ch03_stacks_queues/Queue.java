package org.dav.learn.mcdowell.ch03_stacks_queues;

public class Queue {
	Node first, last;

	void enqueue(Object item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}

	Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}
}
