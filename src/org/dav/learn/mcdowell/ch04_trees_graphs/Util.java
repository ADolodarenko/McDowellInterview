package org.dav.learn.mcdowell.ch04_trees_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Util {
	private static int lastPrinted = Integer.MIN_VALUE;

	public static boolean checkBSTAlt(TreeNode n) {
		return checkBSTAlt(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBSTAlt(TreeNode n, int min, int max) {
		if (n == null)
			return true;

		if (n.getData() <= min || n.getData() > max)
			return false;

		if (!checkBSTAlt(n.left, min, n.getData()) || !checkBSTAlt(n.right, n.getData(), max))
			return false;

		return true;
	}

	public static boolean checkBST(TreeNode n) {
		if (n == null)
			return true;

		if (!checkBST(n.left))
			return false;

		if (n.getData() < lastPrinted)
			return false;
		lastPrinted = n.getData();

		if (checkBST(n.right))
			return false;

		return true;
	}

	//This variant won't do.
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

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListAlt(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

		LinkedList<TreeNode> current = new LinkedList<>();
		if (root != null)
			current.add(root);

		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<>();

			for (TreeNode parent : parents) {
				if (parent.left != null)
					current.add(parent.left);

				if (parent.right != null)
					current.add(parent.right);
			}
		}

		return result;
	}

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null)
			return;

		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<>();
			lists.add(list);
		} else
			list = lists.get(level);

		list.add(root);

		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
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
