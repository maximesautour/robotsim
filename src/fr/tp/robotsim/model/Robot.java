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
		int currentX = getxCoordinate();
		int currentY = getyCoordinate();
		int targetX = target.getxCoordinate();
		int targetY = target.getyCoordinate();
		int step = (int) speed; // pour convertir double speed en un int comme les getPosition() sont des int

		int newX = currentX;
		int newY = currentY;

		// pour x

		if (currentX < targetX) {
			newX = currentX + step;
			if (newX >= targetX) {
				newX = targetX;
			}
		}

		if (currentX > targetX) {
			newX = currentX - step;
			if (newX <= targetX) {
				newX = targetX;
			}
		}

		// pour y

		if (currentY < targetY) {
			newY = currentY + step;
			if (newY >= targetY) {
				newY = targetY;
			}
		}

		if (currentY > targetY) {
			newY = currentY - step;
			if (newY <= targetY) {
				newY = targetY;
			}
		}

		getPosition().setX(newX);
		getPosition().setY(newY);

		// si currentX (ou currentY) == targetX (ou target Y) alors on laisse la valeur
		// de newX et newY
		
		if (getFactory() != null) {
		    getFactory().notifyObservers();
		}
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