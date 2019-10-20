package org.dav.learn.mcdowell.ch03_stacks_queues;

public class StacksBasedQueue<T> {
	private Stack<T> stockStack;
	private Stack<T> bufferStack;
	private T head;

	public StacksBasedQueue(int capacity) {
		stockStack = new Stack<>(capacity);
		bufferStack = new Stack<>(capacity);
	}

	public boolean isEmpty() {
		return stockStack.isEmpty();
	}

	public boolean isFull() {
		return stockStack.isFull();
	}

	public void add(T item) throws Exception {
		if (stockStack.isFull())
			throw new Exception("The queue is full.");

		if (stockStack.isEmpty())
			head = item;

		stockStack.push(item);
	}

	public T remove() throws Exception {
		if (stockStack.isEmpty())
			throw new Exception("The queue is empty.");

		moveItems(stockStack, bufferStack);

		T item = bufferStack.pop();

		if (bufferStack.isEmpty())
			head = null;
		else {
			head = bufferStack.peek();

			moveItems(bufferStack, stockStack);
		}

		return item;
	}

	public T peek() {
		return head;
	}

	private void moveItems(Stack<T> sourceStack, Stack<T> destinationStack) {
		while ( !sourceStack.isEmpty() )
			destinationStack.push(sourceStack.pop());
	}
}
