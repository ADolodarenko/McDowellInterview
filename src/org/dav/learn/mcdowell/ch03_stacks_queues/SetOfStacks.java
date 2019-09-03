package org.dav.learn.mcdowell.ch03_stacks_queues;

import java.util.ArrayList;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<>();
	int stackCapacity;

	public SetOfStacks(int stackCapacity) {
		this.stackCapacity = stackCapacity;
	}

	public void push(int v) {
		Stack last = getLastStack();
		if (last != null && !last.isFull())
			last.push(v);
		else {
			Stack stack = new Stack(stackCapacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int v = (int) last.pop();
		if (last.isEmpty()) stacks.remove(stacks.size() - 1);
		return v;
	}

	Stack getLastStack() {
		if (!stacks.isEmpty())
			return stacks.get(stacks.size() - 1);
		else
			return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < stacks.size(); i++){
			builder.append("stack ");
			builder.append(i);
			builder.append(": capacity = ");
			builder.append(stacks.get(i).capacity);
			builder.append(", size = ");
			builder.append(stacks.get(i).size);
			builder.append("\n");
		}

		return builder.toString();
	}
}
