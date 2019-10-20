package org.dav.learn.mcdowell.ch02_linkedlists;

public class Main
{
	public static void main(String[] args)
	{
		//testDuplicates();
		//testKthElementToLast();
		//testDeletion();
		//testPartition();
		//testSum();
		//testLoop();

		testPalindrome();
	}

	static void testPalindrome() {
		Node a = new Node(0);
		a.appendToTail(1);
		a.appendToTail(2);
		a.appendToTail(1);
		a.appendToTail(0);

		System.out.println(a);
		System.out.println(Util.isPalindrome(a));
		System.out.println(Util.isPalindromeR2(a));
	}

	static void testLoop() {
		Node a = new Node(1);
		Node b = a.appendToTail(2);
		Node c = a.appendToTail(3);
		Node d = a.appendToTail(4);
		d.next = a;

		System.out.println(Util.findBeginning(a).data);
		System.out.println(Util.getFirstInLinkedListLoop(a).data);
		System.out.println(Util.isLinkedListLooped(a));
	}

	static void testSum() {
		Node a = new Node(1);
		a.appendToTail(2);
		a.appendToTail(7);
		System.out.println(a);

		Node b = new Node(2);
		b.appendToTail(1);
		System.out.println(b);

		System.out.println(Util.sum(a, b));
		System.out.println(Util.sum(b, a));
	}

	static void testPartition()
	{
		Node head = new Node(12);
		head.appendToTail(2);
		head.appendToTail(11);
		head.appendToTail(7);
		head.appendToTail(17);
		head.appendToTail(9);
		head.appendToTail(3);

		System.out.println(head.toString());

		Util.partition(head, 8);
		System.out.println(head.toString());
	}

	static void testDeletion()
	{
		Node head = new Node(0);
		for (int i = 1; i < 5; i++)
			head.appendToTail(i);

		System.out.println(head.toString());

		Node node = head;
		for (int i = 1; i < 3; i++)
			node = node.next;

		System.out.println(node.data);

		//Util.deleteFromSinglyLinkedList(node);
		Util.deleteNode(node);

		System.out.println(head.toString());
	}

	static void testKthElementToLast()
	{
		Node head = new Node(0);
		for (int i = 1; i < 5; i++)
			head.appendToTail(i);

		System.out.println(head.toString());

		System.out.println(Util.getKthToLast(head, 5).data);
	}

	static void testDuplicates()
	{
		Node head = new Node(0);
		for (int i = 0; i < 4; i++)
		{
			head.appendToTail(i);

			if (i == 0 || i == 2)
				head.appendToTail(i);
		}

		System.out.println(head.toString());

		Util.dropDuplicates(head);
		System.out.println(head.toString());
	}
}
