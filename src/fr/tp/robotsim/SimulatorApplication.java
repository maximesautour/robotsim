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

public class SimulatorApplication {

	public static void main(String[] args) {

        // création de l'usine
		Factory factory = new Factory(null, "factory", new Position(0, 0), new Dimension(200, 200));

        // création room1 avec sa workarea et sa machine
        Room room1 = new Room("Room 1", new Position(0, 0), new Dimension(60, 60));
        WorkArea workArea1 = new WorkArea("WorkArea 1", new Position(10, 10), new Dimension(40, 40));
        ProductionMachine machine1 = new ProductionMachine("Machine 1", new Position(20, 20), new Dimension(10, 10));
        workArea1.addComponent(machine1);
        room1.addComponent(workArea1);
        factory.addComponent(room1);

        // création room2 avec sa workarea et sa machine
        Room room2 = new Room("Room 2", new Position(70, 0), new Dimension(60, 60));
        WorkArea workArea2 = new WorkArea("WorkArea 2", new Position(80, 10), new Dimension(40, 40));
        ProductionMachine machine2 = new ProductionMachine("Machine 2", new Position(90, 20), new Dimension(10, 10));
        workArea2.addComponent(machine2);
        room2.addComponent(workArea2);
        factory.addComponent(room2);

        // création room3 avec sa workarea et sa machine
        Room room3 = new Room("Room 3", new Position(140, 0), new Dimension(60, 60));
        WorkArea workArea3 = new WorkArea("WorkArea 3", new Position(150, 10), new Dimension(40, 40));
        ProductionMachine machine3 = new ProductionMachine("Machine 3", new Position(160, 20), new Dimension(10, 10));
        workArea3.addComponent(machine3);
        room3.addComponent(workArea3);
        factory.addComponent(room3);

        // ajout de 3 robots et de la station de recharge
        
        Robot robot1 = new Robot("Robot 1", new Position(10, 100), new Dimension(5, 5), 3.0);
        Robot robot2 = new Robot("Robot 2", new Position(50, 100), new Dimension(5, 5), 3.0);
        Robot robot3 = new Robot("Robot 3", new Position(90, 100), new Dimension(5, 5), 3.0);
        ChargingStation chargingStation = new ChargingStation("ChargingStation 1", new Position(150, 150), new Dimension(15, 15));
        factory.addComponent(robot1);
        factory.addComponent(robot2);
        factory.addComponent(robot3);

        
        // on donne des trajets aux robots
        robot1.getComponentsToVisit().add(machine1);
        robot1.getComponentsToVisit().add(machine2);
        robot1.getComponentsToVisit().add(machine3);
        
        robot2.getComponentsToVisit().add(chargingStation);
        robot2.getComponentsToVisit().add(machine1);
        
        robot3.getComponentsToVisit().add(machine2);
        robot3.getComponentsToVisit().add(chargingStation);
        
        // lancement avec contrôleur et affichage de l'usine
        SimulatorController controller = new SimulatorController(factory);
        new CanvasViewer(controller);
    }
}
