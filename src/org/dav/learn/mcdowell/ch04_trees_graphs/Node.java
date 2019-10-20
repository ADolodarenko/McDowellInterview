package org.dav.learn.mcdowell.ch04_trees_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
	private int data;
	private State state;
	private List<Node> adjacent;

	public Node(int data) {
		this.data = data;
		this.state = State.UNVISITED;

		this.adjacent = new ArrayList<>();
	}

	public int getData() {
		return data;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void addOneAdjacent(Node node) {
		adjacent.add(node);
	}

	public List<Node> getAdjacent() {
		return Collections.unmodifiableList(adjacent);
	}
}
