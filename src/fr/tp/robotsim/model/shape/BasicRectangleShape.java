package fr.tp.robotsim.model.shape;

import fr.tp.inf112.projects.canvas.model.RectangleShape;

public class BasicRectangleShape implements RectangleShape {
	private final int width;
	private final int height;
	
	
	public BasicRectangleShape(int width, int height) {
		this.width = width;
		this.height  = height;
	}

	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	
}
