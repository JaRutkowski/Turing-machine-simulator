package com.javafee.tms.graph.elements;

import java.util.List;

public class TuringNode extends Node {

	public static final int HALT = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int ACCEPT = 3;
	public static final int REJECT = 4;

	public static final int FIELDS = 4;

	@SuppressWarnings("unused")
	private int haltStatus;

	private Double xCord;

	private Double yCord;

	public TuringNode(Integer number, String name) {
		super(number, name);
	}

	public TuringNode(Integer number, String name, List<Integer> neighbour) {
		super(number, name, neighbour);
	}

	public TuringNode(Integer number, int haltStatus, String name, List<Integer> neighbour) {
		super(number, name, neighbour);
		this.haltStatus = haltStatus;
	}

	public TuringNode(String name, int haltStatus, Double xCord, Double yCord) {
		super(name);
		this.haltStatus = haltStatus;
		this.xCord = xCord;
		this.yCord = yCord;
	}

	public int getHaltStatus() {
		return haltStatus;
	}

	public void setHaltStatus(int haltStatus) {
		this.haltStatus = haltStatus;
	}

	public Double getxCord() {
		return xCord;
	}

	public void setxCord(Double xCord) {
		this.xCord = xCord;
	}

	public Double getyCord() {
		return yCord;
	}

	public void setyCord(Double yCord) {
		this.yCord = yCord;
	}

}
