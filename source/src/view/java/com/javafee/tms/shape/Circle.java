package com.javafee.tms.shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import lombok.Setter;

public final class Circle {

	final Font font = Font.font("Cooper Black", FontWeight.BOLD, 16);
	// final FontMetrics fm =
	// Toolkit.getToolkit().getFontLoader().getFontMetrics(font);

	@Getter
	public static final int RADIUS = 26;

	@Getter
	private final Integer searchKey;

	@Getter
	@Setter
	private Point2D point;
	@Getter
	@Setter
	private Color backgroundColor;
	@Getter
	@Setter
	private Color borderColor;
	@Getter
	@Setter
	private Color fontColor;

	public Circle(Integer searchKey) {
		this.searchKey = searchKey;
		this.backgroundColor = Color.web("#FCFCFC");
	}

	public Circle(Integer searchKey, Point2D point) {
		this.searchKey = searchKey;
		this.point = point;
		this.backgroundColor = Color.rgb(49, 116, 222);
		this.setBorderColor(Color.rgb(99, 99, 99));
		this.fontColor = Color.web("#FCFCFC");

	}

	public void draw(GraphicsContext graphicsContext) {
		graphicsContext.setLineWidth(3);
		graphicsContext.setFill(backgroundColor);
		graphicsContext.fillOval(point.getX() - RADIUS, point.getY() - RADIUS, 2 * RADIUS, 2 * RADIUS);
		graphicsContext.setStroke(borderColor);
		graphicsContext.strokeOval(point.getX() - RADIUS, point.getY() - RADIUS, 2 * RADIUS, 2 * RADIUS);
		graphicsContext.setFont(font);
		graphicsContext.setFill(getFontColor());
	}

	public void setHighlighter(boolean highlight) {
		if (highlight) {
			setFontColor(Color.rgb(49, 116, 222));
			setBackgroundColor(Color.rgb(155, 244, 167));
			setBorderColor(Color.rgb(49, 116, 222));
		} else {
			setFontColor(Color.web("#FCFCFC"));
			setBackgroundColor(Color.rgb(49, 116, 222));
			setBorderColor(Color.rgb(99, 99, 99));
		}
	}

	@Override
	public String toString() {
		return "Search Key# " + searchKey + " (x,y) = (" + point.getX() + ", " + point.getY() + ")";
	}

}
