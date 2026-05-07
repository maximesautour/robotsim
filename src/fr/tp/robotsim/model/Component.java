package fr.tp.robotsim.model;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

public abstract class Component implements Figure, Serializable{

    private final String name;
    private final Position position;
    private final Dimension dimension;
    private Factory factory;
    public static final long serialVersionUID = 202605071940L;

    public Component(String name, Position position, Dimension dimension) {
        this.name = name;
        this.position = position;
        this.dimension = dimension;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Dimension getDimension() {
        return dimension;
    }
    
    @Override
    public int getxCoordinate() {
    	return position.getX();
    }
    
    @Override
    public int getyCoordinate() {
    	return position.getY();
    }	
    
    @Override
    public Style getStyle() {
    	return null;
    }
    
    public abstract Shape getShape();
    
    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
    
    public void behave() {
    	return;
    }
    
    @Override
    public String toString() {
        return name + " at " + position + " of size " + dimension;
    }
    
    public boolean overlays(Position position) {
        return false;
    }
}