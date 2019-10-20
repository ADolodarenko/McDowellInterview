package org.dav.learn.mcdowell.ch04_trees_graphs;

public class Main {
	public static void main(String[] args) {
		createMinimalBST();
	}

	static void createMinimalBST() {
		int[] array = {0, 1, 2, 3};

		TreeNode root = Util.createMinimalBST(array);
	}

	static void graphSearching() {
		Graph graph = new Graph();
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		a.addOneAdjacent(b);
		a.addOneAdjacent(c);
		c.addOneAdjacent(d);

		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);

		System.out.println("b->c ? " + Util.search(graph, b, c));
		System.out.println("a->d ? " + Util.search(graph, a, d));
	}

	static void balancedTreeChecking() {
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.left.right = new TreeNode(3);
		a.right = new TreeNode(4);

		System.out.println(Util.isBalanced(a));
	}
}
