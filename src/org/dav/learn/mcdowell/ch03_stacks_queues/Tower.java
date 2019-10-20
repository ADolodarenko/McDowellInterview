package org.dav.learn.mcdowell.ch03_stacks_queues;

public class Tower {
	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<>();
		index = i;
	}

	public int getIndex() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from tower " + getIndex() + " to tower " + t.getIndex());
	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}
