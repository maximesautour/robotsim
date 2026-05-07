package fr.tp.robotsim.model;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.robotsim.model.shape.BasicRectangleShape;

public class Room extends CompositeComponent implements Serializable {
	
	public static final long serialVersionUID = 202605071940L;

    public Room(String name, Position position, Dimension dimension) {
        super(name, position, dimension);
    }
    
    @Override
    public Shape getShape() {
        return new BasicRectangleShape(getDimension().getWidth(),getDimension().getHeight());
    } 
    
    @Override
    public String toString() {
        return "[Room] " + super.toString();
    }
    
    @Override
    public boolean overlays(Position position) {
        final int x = position.getX();
        final int y = position.getY();
        final int roomX = getxCoordinate();
        final int roomY = getyCoordinate();
        final int width = getDimension().getWidth();
        final int height = getDimension().getHeight();
        final int wallThickness = 3;

        // Position en dehors de la room → pas un mur
        if (x < roomX || x > roomX + width || y < roomY || y > roomY + height) {
            return false;
        }

        // Position sur l'un des 4 murs
        boolean onLeftWall = x <= roomX + wallThickness;
        boolean onRightWall = x >= roomX + width - wallThickness;
        boolean onTopWall = y <= roomY + wallThickness;
        boolean onBottomWall = y >= roomY + height - wallThickness;

        return onLeftWall || onRightWall || onTopWall || onBottomWall;
    }
}