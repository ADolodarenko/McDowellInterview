package org.dav.learn.mcdowell.ch04_trees_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
	private List<Node> nodes;

	public Graph() {
		nodes = new ArrayList<>();
	}

	public void add(Node newNode) {
		nodes.add(newNode);
	}

	public List<Node> getNodes() {
		return Collections.unmodifiableList(nodes);
	}
}
