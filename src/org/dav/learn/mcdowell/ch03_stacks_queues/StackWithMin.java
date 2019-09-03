package org.dav.learn.mcdowell.ch03_stacks_queues;

public class StackWithMin extends Stack<NodeWithMin> {

	public StackWithMin(int capacity) {
		super(capacity);
	}

	public void push(int value) {
		int newMin = Math.min(value, min());

		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (isEmpty())
			return Integer.MAX_VALUE;
		else
			return peek().min;
	}

}
