package com.javafee.tms.graph.directed;

import java.util.ArrayList;
import java.util.List;

import com.javafee.tms.graph.elements.Edge;
import com.javafee.tms.graph.elements.Node;
import com.javafee.tms.graph.elements.TuringEdge;
import com.javafee.tms.graph.utils.exceptions.IllegalEdgeTypeException;

public class TuringGraph extends DirectedGraph {

	@Override
	public void setEdges(List<Edge> edges) {
		edges.forEach(e -> {
			if (!(e instanceof TuringEdge)) {
				throw new IllegalEdgeTypeException("Edge of turing graph object should be type of turing.");
			}
		});
	}

}
