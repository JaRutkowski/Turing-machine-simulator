package com.javafee.tms.components;

import org.springframework.stereotype.Component;

import com.javafee.tms.shape.Circle;

@Component
public class DirectedGraphGraphic {

	// TODO Szkielet - niezobowiązujący

	public void insertItem(Circle newCircle) {

	}

	protected NodeGraphic insertItem(NodeGraphic tNode, Circle newCircle) {
		return new NodeGraphic();
	}

	public Integer retrieveItem(Integer searchKey) {
		return retrieveItem(new NodeGraphic(), searchKey);
	}

	public void deleteItem(Integer searchKey) {
		deleteItem(new NodeGraphic(), searchKey);
	}

	public Circle findLeftmost(NodeGraphic tNode) {
		return findLeftmost(tNode);
	}

	public void setResetColor(NodeGraphic tNode) {
		resetColor(tNode);
	}

	public int getHeight(NodeGraphic root) {
		return 0;
	}

	public int getSize(NodeGraphic root) {
		return 0;
	}

	public void setRootItem(Circle newItem) {

	}

	private Integer retrieveItem(NodeGraphic tNode, Integer searchKey) {
		return 0;
	}

	private NodeGraphic deleteItem(NodeGraphic tNode, Integer searchKey) {
		return new NodeGraphic();
	}

	private void resetColor(NodeGraphic tNode) {

	}

}
