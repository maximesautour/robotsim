package fr.tp.robotsim.model;

import java.util.ArrayList;

public class Factory {

    private final String name;

    private final ArrayList<Robot> robots;

    public Factory(String name) {
        this.name = name;
        this.robots = new ArrayList<Robot>();
    }

    private boolean checkRobotName(String name) {
        for (Robot robot : robots) {
            if (robot.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean addRobot(String name) {
        if (!checkRobotName(name)) {
            return false;
        }
        else {
            robots.add(new Robot(name, 0.0));
            return true;
        }
    }

    public void printToConsole() {
        System.out.println("Le nom de l'usine est " + name + ".");
        for (Robot robot : robots) {
            System.out.println(robot);
        }
    }
}