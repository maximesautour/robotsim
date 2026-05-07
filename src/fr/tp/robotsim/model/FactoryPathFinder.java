package fr.tp.robotsim.model;

import java.util.List;

public interface FactoryPathFinder {
    List<Position> findPath(Component source, Component target);
}