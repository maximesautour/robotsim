package fr.tp.robotsim.model;

import java.io.Serializable;

public class Dimension implements Serializable {
	
	public static final long serialVersionUID = 202605071940L;

    private final int width;
    private final int height;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return width + "x" + height;
    }
}