package com.javafee.tms.graph.elements;

import java.util.List;

public class TuringNode extends Node {

	@SuppressWarnings("unused")
	private int haltStatus;

	public TuringNode(int number, String name) {
		super(number, name);
	}

	public TuringNode(int number, String name, List<Node> neighbour) {
		super(number, name, neighbour);
	}

	public TuringNode(int number, int haltStatus, String name, List<Node> neighbour) {
		super(number, name, neighbour);
		this.haltStatus = haltStatus;
	}

}
