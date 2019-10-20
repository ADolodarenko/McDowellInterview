package org.dav.learn.mcdowell.ch02_linkedlists;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class Util
{
	public static boolean isPalindromeR3(Node head) {
		Result p = isPalindromeRecurse(head, listSize(head));
		return p.result;
	}

	private static Result isPalindromeRecurse(Node head, int length) {
		if (head == null || length == 0)
			return new Result(null, true);
		else if (length == 1)
			return new Result(head.next, true);
		else if (length == 2)
			return new Result(head.next.next, head.data == head.next.data);

		Result res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null)
			return res;
		else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}

	private static int listSize(Node head) {
		int i = 0;

		while (head != null) {
			i++;
			head = head.next;
		}

		return i;
	}

	public static boolean isPalindromeR2(Node head) {
		Node fast = head;
		Node slow = head;

		Stack<Integer> stack = new Stack<>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null)
			slow = slow.next;

		while (slow != null) {
			int top = stack.pop().intValue();

			if (top != slow.data)
				return false;

			slow = slow.next;
		}

		return true;
	}

	public static boolean isPalindrome(Node head) {
		Node first = head;
		Node mirror = null;
		int i = 0;
		while (first != null) {
			i++;

			Node node = new Node(first.data);
			node.next = mirror;
			mirror = node;

			first = first.next;
		}

		if (mirror == null)
			return false;

		i = i / 2;

		for (int j = 0; j <= i; j++) {
			if (mirror.data != head.data)
				return false;

			head = head.next;
			mirror = mirror.next;
		}

		return true;
	}

	public static Node findBeginning(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}

	public static boolean isLinkedListLooped(Node head) {
		if (head == null || head.next == null)
			return false;

		Node first = head;
		Node second = head.next;

		while (first != null || second != null) {
			if (first == second)
				return true;

			if (second.next == null)
				return false;
			else {
				first = first.next;
				second = second.next.next;
			}
		}

		return false;
	}

	public static Node getFirstInLinkedListLoop(Node head) {
		if (head == null || head.next == null)
			return null;

		Map<Node, Integer> nodesMap = new HashMap<>();

		while (head != null) {
			if (nodesMap.containsKey(head))
				return head;
			else
				nodesMap.put(head, 1);

			head = head.next;
		}

		return null;
	}

	public static Node addLists(Node l1, Node l2) {
		int len1 = length(l1);
		int len2 = length(l2);

		if (len1 < len2)
			l1 = padList(l1, len2 - len1);
		else
			l2 = padList(l2, len1 - len2);

		PartialSum sum = addListsHelper(l1, l2);

		if (sum.carry == 0)
			return sum.sum;
		else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	public static int length(Node head) {
		int i = 0;
		while (head != null) {
			i++;
			head = head.next;
		}

		return i;
	}

	public static PartialSum addListsHelper(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}

		PartialSum sum = addListsHelper(l1.next, l2.next);

		int val = sum.carry + l1.data + l2.data;

		Node fullResult = insertBefore(sum.sum, val % 10);

		sum.sum = fullResult;
		sum.carry = val / 10;

		return sum;
	}

	public static Node padList(Node l, int padding) {
		Node head = l;
		for (int i = 0; i < padding; i++) {
			Node n = new Node(0);
			n.next = head;
			head = n;
		}

		return head;
	}

	public static Node insertBefore(Node list, int data) {
		Node node = new Node(data);

		if (list != null)
			node.next = list;

		return node;
	}

	public static Node addlists(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;

		Node result = new Node(carry);

		int value = carry;
		if (l1 != null)
			value += l1.data;
		if (l2 != null)
			value += l2.data;

		result.data = value % 10;

		if (l1 != null || l2 != null || value >= 10) {
			Node more = addlists(l1 == null ? null : l1.next,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);

			result.next = more;
		}

		return result;
	}


	public static Node sum(Node a, Node b) {
		Node x = a;
		Node y = b;
		Node result = null, z = null;
		int left = 0;

		while (x != null || y != null || left > 0) {
			if (z == null) {
				z = new Node(0);
				result = z;
			} else {
				z.next = new Node(0);
				z = z.next;
			}

			if (x != null) z.data += x.data;
			if (y != null) z.data += y.data;
			if (left > 0) z.data += left;

			if (z.data > 9) {
				left = 1;
				z.data -= 10;
			} else
				left = 0;

			if (x != null) x = x.next;
			if (y != null) y = y.next;
		}

		return result;
	}

	public static Node partition(Node node, int x) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;

		while (node != null) {
			Node next = node.next;
			node.next = null;

			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}

			node = next;
		}

		if (beforeStart == null)
			return afterStart;

		beforeEnd.next = afterStart;

		return beforeStart;
	}

	public static Node partitionR2(Node node, int x)
	{
		Node beforeStart = null;
		Node afterStart = null;

		while (node != null) {
			Node next = node.next;

			if (node.data < x) {
				node.next = beforeStart;
				beforeStart = node;
			} else {
				node.next = afterStart;
				afterStart = node;
			}

			node = next;
		}

		if (beforeStart == null)
			return afterStart;

		Node head = beforeStart;
		while (beforeStart.next != null)
			beforeStart = beforeStart.next;

		beforeStart.next = afterStart;

		return head;
	}

	public static void partitionD(Node head, int k) {
		if (head == null || head.next == null)
			return;

		Node end = head;
		int i = 0;
		while (end.next != null){
			end = end.next;
			i++;
		}

		for (int j = 0; j <= i; j++) {
			if (head.data >= k){
				Node newNode = new Node(head.data);
				newNode.next = end.next;
				end.next = newNode;

				head.data = head.next.data;
				head.next = head.next.next;
			} else
				head = head.next;
		}
	}

	public static boolean deleteNode(Node node)
	{
		if (node == null || node.next == null)
			return false;

		Node next = node.next;
		node.data = next.data;
		node.next = next.next;

		return true;
	}

	//Quite a stupid thing I've done here. No need to make a circuit.
	public static void deleteFromSinglyLinkedList(Node element)
	{
		if (element == null) return;

		Node current = element;
		Node previous = element;
		while (current.next != null) {
			current = current.next;
			previous.data = current.data;
			previous.next = current.next;
			previous = current;
		}
	}

	public static int nthToLast(Node head, int k)
	{
		if (head == null) return 0;

		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}

		return i;
	}

	public static Node nthToLastR2(Node head, int k, IntWrapper i)
	{
		if (head == null) return null;

		Node node = nthToLastR2(head.next, k, i);
		i.setValue(i.getValue() + 1);
		if (i.getValue() == k)
			return head;

		return node;
	}

	public static Node nthToLastR3(Node head, int k) {
		if (k <= 0) return null;

		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k - 1; i++) {
			if (p2 == null) return null;
			p2 = p2.next;
		}
		if (p2 == null) return null;

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

	public static Node getKthToLast(Node head, int k)
	{
		if (k < 1 || head == null)
			return null;

		Node first = head;
		Node second = first;
		int i = 1;
		while (i < k && second.next != null)
		{
			second = second.next;
			i++;
		}

		if (i < k)
			return null;

		while (second.next != null)
		{
			second = second.next;
			first = first.next;
		}

		return first;
	}

	public static void deleteDups(Node n)
	{
		Hashtable table = new Hashtable();
		Node previous = null;
		while (n != null)
		{
			if (table.containsKey(n.data))
				previous.next = n.next;
			else {
				table.put(n.data, true);
				previous = n;
			}

			n = n.next;
		}
	}

	public static void deleteDupsAlt(Node head) {
		if (head == null)
			return;

		Node current = head;
		while (current != null) {
			Node runner = current;

			while (runner.next != null) {
				if (runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}

			current = current.next;
		}
	}

	public static void dropDuplicates(Node head)
	{
		if (head == null || head.next == null)
			return;

		Node first = head;
		Node second = first;

		while (first.next != null)
		{
			while (second.next != null)
			{
				if (second.next.data == first.data)
					second.next = second.next.next;
				else
					second = second.next;
			}

			first = first.next;
			second = first;
		}
	}
}
