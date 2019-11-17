package org.dav.learn.mcdowell.ch04_trees_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Util {

	public static boolean isBinarySearchTree(TreeNode root) {
		if (root == null)
			return false;

		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.remove();

			TreeNode child = node.left;
			if (child != null)
				if (child.getData() > node.getData())
					return false;

			child = node.right;
			if (child != null)
				if (child.getData() <= node.getData())
					return false;

			nodes.add(node.left);
			nodes.add(node.right);
		}

		return true;
	}

	public static TreeNode createMinimalBST(int sortedArray[]) {
		return createMinimalBST(sortedArray, 0, sortedArray.length - 1);
	}

	public static TreeNode createMinimalBST(int sortedArray[], int startIndex, int endIndex) {
		if (endIndex < startIndex)
			return null;

		int mediumIndex = (startIndex + endIndex) / 2;
		TreeNode root = new TreeNode(sortedArray[mediumIndex]);
		root.left = createMinimalBST(sortedArray, startIndex, mediumIndex - 1);
		root.right = createMinimalBST(sortedArray, mediumIndex + 1, endIndex);

		return root;
	}

	public static boolean search(Graph graph, Node start, Node end) {
		LinkedList<Node> queue = new LinkedList<>();

		for (Node node : graph.getNodes())
			node.setState(State.UNVISITED);

		start.setState(State.VISITING);
		queue.add(start);
		Node node;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			if (node != null) {
				for (Node adj : node.getAdjacent()) {
					if (adj.getState() == State.UNVISITED) {
						if (adj == end)
							return true;
						else {
							adj.setState(State.VISITING);
							queue.add(adj);
						}
					}
				}
			}
			node.setState(State.VISITED);
		}

		return false;
	}

	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != -1;
	}

	private static int checkHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1;

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	private Util() {}
}
