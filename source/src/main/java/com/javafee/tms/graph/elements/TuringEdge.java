package com.javafee.tms.graph.elements;

public class TuringEdge extends Edge {
	
	private String oldState;
	private String newState;
	private String oldSymbol;
	private String newSymbol;
	private Double curve;

	public TuringEdge(String oldState, String newState, String oldSymbol, String newSymbol, Double curve) {
		this.oldState = oldState;
		this.newState = newState;
		this.oldSymbol = oldSymbol;
		this.newSymbol = newSymbol;
		this.curve = curve;

	}

	public String getOldState() {
		return oldState;
	}

	public void setOldState(String oldState) {
		this.oldState = oldState;
	}

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public String getOldSymbol() {
		return oldSymbol;
	}

	public void setOldSymbol(String oldSymbol) {
		this.oldSymbol = oldSymbol;
	}

	public String getNewSymbol() {
		return newSymbol;
	}

	public void setNewSymbol(String newSymbol) {
		this.newSymbol = newSymbol;
	}

	public Double getCurve() {
		return curve;
	}

	public void setCurve(Double curve) {
		this.curve = curve;
	}

	public String getDirection() {
		return getName();
	}

}
