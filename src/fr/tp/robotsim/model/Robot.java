package fr.tp.robotsim.model;

public class Robot {
	private final String name;

	private double speed;
	
	
	public Robot(String name, double speed) {
		super();
		this.name = name;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Je m'appelle " + name + " et j'avance à " + speed + " km/h.";
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}
}
