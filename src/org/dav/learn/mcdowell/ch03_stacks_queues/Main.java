package org.dav.learn.mcdowell.ch03_stacks_queues;

public class Main {
	public static void main(String[] args) {
		testStacksBasedQueue();
	}

	static void testStacksBasedQueue() {
		StacksBasedQueue<Integer> queue = new StacksBasedQueue<>(100);

		try {
			for (int i = 0; i < 10; i++) {
				queue.add(i);
				System.out.println(i + " has been pushed.");
			}

			while (!queue.isEmpty()) {
				System.out.println(queue.peek() + " has been peeked.");
				System.out.println(queue.remove() + " has been poped.");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	static void testTowers() {
		int n = 3;

		Tower[] towers = new Tower[n];
		for (int i = 0; i < n; i++)
			towers[i] = new Tower(i);

		for (int i = n - 1; i >= 0; i--)
			towers[0].add(i);

		towers[0].moveDisks(n, towers[2], towers[1]);
	}

	static void testSetOfStacks() {
		SetOfStacks setOfStacks = new SetOfStacks(2);
		System.out.println(setOfStacks.toString());

		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		setOfStacks.push(5);

		System.out.println(setOfStacks.toString());

		setOfStacks.pop();
		setOfStacks.pop();
		setOfStacks.pop();
		setOfStacks.pop();
		setOfStacks.pop();

		System.out.println(setOfStacks.toString());
	}
}
