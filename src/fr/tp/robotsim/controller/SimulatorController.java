package fr.tp.robotsim.controller;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.view.FileCanvasChooser;
import fr.tp.robotsim.model.Factory;
import fr.tp.robotsim.model.impl.FileSystemCanvasPersistenceManager;

public class SimulatorController implements CanvasViewerController {
    
    private Factory factoryModel;
    private final CanvasPersistenceManager persistenceManager;
    
    public SimulatorController(Factory factoryModel) {
        this.factoryModel = factoryModel;
        this.persistenceManager = new FileSystemCanvasPersistenceManager(new FileCanvasChooser("rsim", "Robot Simulator"));
    }
    
    @Override
    public boolean addObserver(Observer observer) {
        return factoryModel.addObserver(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return factoryModel.removeObserver(observer);
    }
    
    @Override
    public void startAnimation() {
        factoryModel.startSimulation();
    }

    @Override
    public void stopAnimation() {
        factoryModel.stopSimulation();
    }

    @Override
    public boolean isAnimationRunning() {
        return factoryModel.isSimulationRunning();
    }
    
    @Override
    public Canvas getCanvas() {
        return factoryModel;
    }

    @Override
    public void setCanvas(Canvas canvasModel) {
        this.factoryModel = (Factory) canvasModel;
    }
    
    @Override
    public CanvasPersistenceManager getPersistenceManager() {
        return persistenceManager;
    }
}
