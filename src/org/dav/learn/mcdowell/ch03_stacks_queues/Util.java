package org.dav.learn.mcdowell.ch03_stacks_queues;

public class Util {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp)
				s.push(r.pop());

			r.push(tmp);
		}

		return r;
	}

	private Util(){}
}
