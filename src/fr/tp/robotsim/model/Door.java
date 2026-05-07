package fr.tp.robotsim.model;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.robotsim.model.shape.BasicRectangleShape;

public class Door extends Component implements Serializable{

    private boolean isOpen;
    public static final long serialVersionUID = 202605071940L;

    public Door(String name, Position position, Dimension dimension) {
        super(name, position, dimension);
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    @Override
    public Shape getShape() {
        return new BasicRectangleShape(getDimension().getWidth(),getDimension().getHeight());
    }

    @Override
    public String toString() {
        return "[Door] " + super.toString() + " - " + (isOpen ? "open" : "closed");
    }
}