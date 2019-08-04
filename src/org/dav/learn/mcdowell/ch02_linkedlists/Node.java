package org.dav.learn.mcdowell.ch02_linkedlists;

public class Node
{
	Node next = null;
	int data;

	public Node(int d)
	{
		data = d;
	}

	public void appendToTail(int d)
	{
		Node end = new Node(d);
		Node n = this;

		while (n.next != null)
			n = n.next;

		n.next = end;
	}

	@Override
	public String toString()
	{
		Node node = this;
		StringBuilder builder = new StringBuilder();

		while (node != null)
		{
			builder.append(node.data);
			builder.append(';');

			node = node.next;
		}

		return builder.toString();
	}
}
