package com.javafee.tms.shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.Getter;

public final class Line {

	private static final Color UI_DEFAULT_COLOR = Color.rgb(99, 99, 99);
	private static final Color HIGHLIGHT_COLOR = Color.rgb(49, 116, 222);

	@Getter
	private Point2D firstPoint, secondPoint;
	@Getter
	private double radius;
	private Color color;

	public Line() {
		this.color = UI_DEFAULT_COLOR;
	}

	public Line(Point2D firstPoint, Point2D secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.color = UI_DEFAULT_COLOR;
	}
	
	public Line(Point2D firstPoint, Point2D secondPoint, double radius) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.radius = radius;
		this.color = UI_DEFAULT_COLOR;
	}

	public void draw(GraphicsContext graphicContext) {
		graphicContext.setLineWidth(4);
		graphicContext.setStroke(color);
		graphicContext.strokeLine(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
	}
	
	public void draw(GraphicsContext graphicContext, double radius) {
		graphicContext.setLineWidth(4);
		graphicContext.setStroke(color);
		graphicContext.arcTo(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY(), radius);
	}

	public void setPoints(Point2D firstPoint, Point2D secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
	}

	public void setHighlighter(boolean highlight) {
		this.color = highlight ? HIGHLIGHT_COLOR : UI_DEFAULT_COLOR;
	}

	@Override
	public String toString() {
		return " (x,y) = (" + firstPoint.getX() + ", " + firstPoint.getY() + ")" + " (x,y) = (" + secondPoint.getX()
				+ ", " + secondPoint.getY() + ")" + radius != null ? ", radius = " + radius : "";
	}
	
}
