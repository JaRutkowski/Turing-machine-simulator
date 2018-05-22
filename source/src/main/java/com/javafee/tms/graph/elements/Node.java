package com.javafee.tms.graph.elements;

import java.util.List;

abstract public class Node implements Coordinates {

	private int number;
	private String name;
	private List<Node> neighbors;

	public Node(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public Node(int number, String name, List<Node> neighbors) {
		this.number = number;
		this.name = name;
		this.neighbors = neighbors;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}

}
