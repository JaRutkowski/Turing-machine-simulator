package com.javafee.tms.graph;

import java.util.LinkedList;
import java.util.List;

import com.javafee.tms.graph.elements.Edge;
import com.javafee.tms.graph.elements.Node;

abstract public class Graph {

	protected LinkedList<Node> nodes = new LinkedList<Node>();
	protected LinkedList<Edge> edges = new LinkedList<Edge>();

	public Graph(LinkedList<Node> nodes, LinkedList<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(LinkedList<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Edge> edges) {
		this.edges = edges;
	}

	public void addNode(Node node) {
		this.nodes.add(node);
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public Node findNodeByNumber(Integer number) {
		Node resultNode = null;

		for (Node node : nodes) { // do przemyślenia wyrażenie lambda
			if (node.getNumber() == number) {
				resultNode = node;
				break;
			}
		}

		return resultNode;
	}

}
