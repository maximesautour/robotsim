package fr.tp.robotsim.test;

import fr.tp.robotsim.model.Robot;
import fr.tp.robotsim.model.Factory;

public class TestRobotSim {

    public static void main(String[] args) {
        Robot myRobot = new Robot("Robot 1", 5.0);
        System.out.println(myRobot);

        Factory myFactory = new Factory("usine test");
        System.out.println(myFactory.addRobot("robot 1"));   // true
        System.out.println(myFactory.addRobot("robot 2"));   // true
        System.out.println(myFactory.addRobot("robot 1"));   // false
        myFactory.printToConsole();
    }

}