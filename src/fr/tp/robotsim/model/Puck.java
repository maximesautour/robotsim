package fr.tp.robotsim.model;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.robotsim.model.shape.BasicRectangleShape;

public class Puck extends Component implements Serializable {
	
	public static final long serialVersionUID = 202605071940L;

    public Puck(String name, Position position, Dimension dimension) {
        super(name, position, dimension);
    }
    
    @Override
    public Shape getShape() {
        return new BasicRectangleShape(getDimension().getWidth(),getDimension().getHeight());
    }
    
    @Override
    public String toString() {
        return "[Puck] " + super.toString();
    }
} 