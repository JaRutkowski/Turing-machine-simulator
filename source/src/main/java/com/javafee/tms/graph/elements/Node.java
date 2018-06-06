package com.javafee.tms.graph.elements;

import java.util.List;

abstract public class Node {

	private Integer number;
	private String name;
	private List<Integer> neighbors;

	public Node(String name) {
		this.name = name;
	}

	public Node(Integer number) {
		this.number = number;
	}

	public Node(Integer number, String name) {
		this.number = number;
		this.name = name;
	}

	public Node(Integer number, String name, List<Integer> neighbors) {
		this.number = number;
		this.name = name;
		this.neighbors = neighbors;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Integer> neighbors) {
		this.neighbors = neighbors;
	}

}
