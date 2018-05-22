package com.javafee.tms.graph;

import java.util.LinkedList;
import java.util.List;

import com.javafee.tms.graph.elements.Edge;
import com.javafee.tms.graph.elements.Node;

abstract public class Graph {
	
	protected List<Node> nodes = new LinkedList<Node>();
	protected List<Edge> edges = new LinkedList<Edge>();

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

	public void addNode(Node node) {
		this.nodes.add(node);
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public Node findNodeByNumber(Integer number) {
		Node resultNode = null;

		for (Node node : nodes) {              // do przemyślenia wyrażenie lambda
			if (node.getNumber() == number) {
				resultNode = node;
				break;
			}
		}

		return resultNode;
	}

}
