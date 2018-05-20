package com.javafee.tms.graph;

import java.util.ArrayList;
import java.util.List;

import com.javafee.tms.graph.elements.Edge;
import com.javafee.tms.graph.elements.Node;

abstract public class Graph {
	
	protected List<Node> nodes;
	protected List<Edge> edges;

	public Graph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public void addNode(Node w) {
		this.nodes.add(w);
	}

	public void addKrawedz(Edge k) {
		this.edges.add(k);
	}

	public Node findNodeByNumber(int number) {
		Node resultNode = null;

		for (Node node : nodes) {
			if (node.getNumber() == number) {
				resultNode = node;
				break;
			}
		}

		return resultNode;
	}

}
