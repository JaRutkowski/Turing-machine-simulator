package com.javafee.tms.graph.directed;

import java.util.LinkedList;

import com.javafee.tms.graph.elements.Edge;
import com.javafee.tms.graph.elements.Node;
import com.javafee.tms.graph.elements.TuringEdge;
import com.javafee.tms.graph.elements.TuringNode;
import com.javafee.tms.graph.utils.exceptions.IllegalEdgeTypeException;
import com.javafee.tms.graph.utils.exceptions.IllegalNodeTypeException;

public class TuringGraph extends DirectedGraph {

	public TuringGraph(LinkedList<Node> nodes, LinkedList<Edge> edges) {
		// TODO rzutowanie
		super(nodes, edges);
	}

	@Override
	public void setNodes(LinkedList<Node> nodes) {
		nodes.forEach(e -> {
			if (!(e instanceof TuringNode)) {
				throw new IllegalNodeTypeException("Node of turing graph object should be type of turing.");
			} else {
				this.nodes.add(e);
			}
		});
	}

	@Override
	public void setEdges(LinkedList<Edge> edges) {
		edges.forEach(e -> {
			if (!(e instanceof TuringEdge)) {
				throw new IllegalEdgeTypeException("Edge of turing graph object should be type of turing.");
			} else {
				this.edges.add(e);
			}
		});
	}

}
