package fr.tp.robotsim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.robotsim.model.shape.BasicOvalShape;

public class Robot extends Component implements Serializable {

	private double speed;
	private final List<Component> componentsToVisit;
	private int currentTargetIndex;
	public static final long serialVersionUID = 202605071940L;

	public Robot(String name, Position position, Dimension dimension, double speed) {
		super(name, position, dimension);
		this.speed = speed;
		this.componentsToVisit = new ArrayList<Component>();
		this.currentTargetIndex = 0;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public Shape getShape() {
		return new BasicOvalShape(getDimension().getWidth(), getDimension().getHeight());
	}

	public List<Component> getComponentsToVisit() {
		return componentsToVisit;
	}

	public void move(Component target) {
	    final int currentX = getxCoordinate();
	    final int currentY = getyCoordinate();
	    final int targetX = target.getxCoordinate();
	    final int targetY = target.getyCoordinate();
	    final int step = (int) speed;

	    int newX = currentX;
	    int newY = currentY;

	    // Direction préférée vers la cible
	    int dx = 0;
	    if (currentX < targetX) {
	        dx = step;
	    }
	    else if (currentX > targetX) {
	        dx = -step;
	    }

	    int dy = 0;
	    if (currentY < targetY) {
	        dy = step;
	    }
	    else if (currentY > targetY) {
	        dy = -step;
	    }

	    // Essai 1 : déplacement direct (x et y)
	    Position attempt1 = new Position(currentX + dx, currentY + dy);
	    if (!isBlocked(attempt1)) {
	        newX = currentX + dx;
	        newY = currentY + dy;
	    }
	    // Essai 2 : déplacement seulement en x
	    else if (dx != 0 && !isBlocked(new Position(currentX + dx, currentY))) {
	        newX = currentX + dx;
	    }
	    // Essai 3 : déplacement seulement en y
	    else if (dy != 0 && !isBlocked(new Position(currentX, currentY + dy))) {
	        newY = currentY + dy;
	    }
	    // Essai 4 : contournement perpendiculaire (haut ou bas)
	    else if (!isBlocked(new Position(currentX, currentY + step))) {
	        newY = currentY + step;
	    }
	    else if (!isBlocked(new Position(currentX, currentY - step))) {
	        newY = currentY - step;
	    }
	    // Si tout est bloqué, on ne bouge pas

	    // Pas dépasser la cible
	    if (dx > 0 && newX > targetX) {
	        newX = targetX;
	    }
	    else if (dx < 0 && newX < targetX) {
	        newX = targetX;
	    }
	    if (dy > 0 && newY > targetY) {
	        newY = targetY;
	    }
	    else if (dy < 0 && newY < targetY) {
	        newY = targetY;
	    }

	    getPosition().setX(newX);
	    getPosition().setY(newY);

	    if (getFactory() != null) {
	        getFactory().notifyObservers();
	    }
	}

	private boolean isBlocked(Position position) {
	    if (getFactory() == null) {
	        return false;
	    }
	    return getFactory().isObstacle(position);
	}
	
	
	@Override
	public void behave() {
		if (componentsToVisit.isEmpty()) {
			return;
		}

		Component target = componentsToVisit.get(currentTargetIndex);

		if (getxCoordinate() == target.getxCoordinate() && getyCoordinate() == target.getyCoordinate()) {
			currentTargetIndex++;
			if (currentTargetIndex > componentsToVisit.size() - 1) {
				currentTargetIndex = 0;
			}
		} else {
			move(target);
		}
	}

	@Override
	public String toString() {
		return "[Robot] " + super.toString() + " - speed: " + speed + " km/h";
	}
}