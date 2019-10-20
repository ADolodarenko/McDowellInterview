package org.dav.learn.mcdowell.ch03_stacks_queues;

public class MyQueue<T> {
	private Stack<T> stackNewest, stackOldest;

	public MyQueue() {
		stackNewest = new Stack<>();
		stackOldest = new Stack<>();
	}

	public int size() {
		return stackNewest.size + stackOldest.size;
	}

	public void add(T value) {
		stackNewest.push(value);
	}

	public T peek() {
		shiftStacks();

		return stackOldest.peek();
	}

	public T remove() {
		shiftStacks();

		return stackOldest.pop();
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty())
			while (!stackNewest.isEmpty())
				stackOldest.push(stackNewest.pop());
	}
}
