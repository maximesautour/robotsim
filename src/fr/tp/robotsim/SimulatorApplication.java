package fr.tp.robotsim;

import fr.tp.inf112.projects.canvas.view.CanvasViewer;
import fr.tp.robotsim.controller.SimulatorController;
import fr.tp.robotsim.model.ChargingStation;
import fr.tp.robotsim.model.Dimension;
import fr.tp.robotsim.model.Factory;
import fr.tp.robotsim.model.Position;
import fr.tp.robotsim.model.ProductionMachine;
import fr.tp.robotsim.model.Robot;
import fr.tp.robotsim.model.Room;
import fr.tp.robotsim.model.WorkArea;
import java.util.Arrays;
import java.util.logging.Logger;

public class SimulatorApplication {
	
	private static final Logger LOGGER = Logger.getLogger(SimulatorApplication.class.getName());

	public static void main(String[] args) {
		
		LOGGER.info("Starting the robot simulator...");
		LOGGER.config("With parameters '" + Arrays.toString(args) + "'.");

		// création d'une usine plus spacieuse
		Factory factory = new Factory(null, "factory", new Position(0, 0), new Dimension(300, 250));

		// trois rooms en haut
		Room room1 = new Room("Room 1", new Position(0, 0), new Dimension(60, 60));
		WorkArea workArea1 = new WorkArea("WorkArea 1", new Position(10, 10), new Dimension(40, 40));
		ProductionMachine machine1 = new ProductionMachine("Machine 1", new Position(20, 20), new Dimension(10, 10));
		workArea1.addComponent(machine1);
		room1.addComponent(workArea1);
		factory.addComponent(room1);

		Room room2 = new Room("Room 2", new Position(120, 0), new Dimension(60, 60));
		WorkArea workArea2 = new WorkArea("WorkArea 2", new Position(130, 10), new Dimension(40, 40));
		ProductionMachine machine2 = new ProductionMachine("Machine 2", new Position(140, 20), new Dimension(10, 10));
		workArea2.addComponent(machine2);
		room2.addComponent(workArea2);
		factory.addComponent(room2);

		Room room3 = new Room("Room 3", new Position(240, 0), new Dimension(60, 60));
		WorkArea workArea3 = new WorkArea("WorkArea 3", new Position(250, 10), new Dimension(40, 40));
		ProductionMachine machine3 = new ProductionMachine("Machine 3", new Position(260, 20), new Dimension(10, 10));
		workArea3.addComponent(machine3);
		room3.addComponent(workArea3);
		factory.addComponent(room3);

		// trois stations de recharge à différentes positions
		ChargingStation chargingStation1 = new ChargingStation("Charging 1", new Position(20, 200), new Dimension(15, 15));
		ChargingStation chargingStation2 = new ChargingStation("Charging 2", new Position(150, 200), new Dimension(15, 15));
		ChargingStation chargingStation3 = new ChargingStation("Charging 3", new Position(270, 200), new Dimension(15, 15));
		factory.addComponent(chargingStation1);
		factory.addComponent(chargingStation2);
		factory.addComponent(chargingStation3);

		// trois robots à différentes positions de départ
		Robot robot1 = new Robot("Robot 1", new Position(20, 100), new Dimension(5, 5), 3.0);
		Robot robot2 = new Robot("Robot 2", new Position(150, 100), new Dimension(5, 5), 3.0);
		Robot robot3 = new Robot("Robot 3", new Position(270, 100), new Dimension(5, 5), 3.0);
		factory.addComponent(robot1);
		factory.addComponent(robot2);
		factory.addComponent(robot3);

		// chaque robot fait des allers-retours en passant par les autres stations
		robot1.getComponentsToVisit().add(chargingStation2);
		robot1.getComponentsToVisit().add(chargingStation3);
		robot1.getComponentsToVisit().add(chargingStation1);

		robot2.getComponentsToVisit().add(chargingStation3);
		robot2.getComponentsToVisit().add(chargingStation1);
		robot2.getComponentsToVisit().add(chargingStation2);

		robot3.getComponentsToVisit().add(chargingStation1);
		robot3.getComponentsToVisit().add(chargingStation2);
		robot3.getComponentsToVisit().add(chargingStation3);

		// Lancement
		SimulatorController controller = new SimulatorController(factory);
		new CanvasViewer(controller);
    }
}
