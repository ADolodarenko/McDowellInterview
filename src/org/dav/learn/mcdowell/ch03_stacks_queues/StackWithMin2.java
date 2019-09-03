package org.dav.learn.mcdowell.ch03_stacks_queues;

public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> minsStack;

	public StackWithMin2(int capacity) {
		super(capacity);
		minsStack = new Stack<>(capacity);
	}

	@Override
	public void push(Integer item) {
		if (item <= min())
			minsStack.push(item);

		super.push(item);
	}

	@Override
	public Integer pop() {
		int value = super.pop();

		if (value == min())
			minsStack.pop();

		return value;
	}

	public int min() {
		if (minsStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minsStack.peek();
	}
}
