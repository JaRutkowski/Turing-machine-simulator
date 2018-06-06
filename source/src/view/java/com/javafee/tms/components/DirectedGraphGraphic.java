package com.javafee.tms.components;

import org.springframework.stereotype.Component;

import com.javafee.tms.shape.Circle;

@Component
public class DirectedGraphGraphic {

	// TODO Szkielet - niezobowiązujący

	public void insertItem(Circle newCircle) {

	}

	protected GraphNode insertItem(GraphNode tNode, Circle newCircle) {
		return new GraphNode();
	}

	public Integer retrieveItem(Integer searchKey) {
		return retrieveItem(new GraphNode(), searchKey);
	}

	public void deleteItem(Integer searchKey) {
		deleteItem(new GraphNode(), searchKey);
	}

	public Circle findLeftmost(GraphNode tNode) {
		return findLeftmost(tNode);
	}

	public void setResetColor(GraphNode tNode) {
		resetColor(tNode);
	}

	public int getHeight(GraphNode root) {
		return 0;
	}

	public int getSize(GraphNode root) {
		return 0;
	}

	public void setRootItem(Circle newItem) {

	}

	private Integer retrieveItem(GraphNode tNode, Integer searchKey) {
		return 0;
	}

	private GraphNode deleteItem(GraphNode tNode, Integer searchKey) {
		return new GraphNode();
	}

	private void resetColor(GraphNode tNode) {

	}

}
