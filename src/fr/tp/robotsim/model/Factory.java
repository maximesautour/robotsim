package fr.tp.robotsim.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import fr.tp.inf112.projects.canvas.controller.Observable;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.robotsim.model.shape.BasicRectangleShape;


public class Factory extends CompositeComponent implements Canvas, Observable, Serializable {
	private transient Set<Observer> observers;
	
	private String id;
	private transient boolean simulationRunning;
	public static final long serialVersionUID = 202605071940L;

	public Factory(String id, String name, Position position, Dimension dimension) {
	    super(name, position, dimension);
	    this.id = id;
	    this.simulationRunning = false;
	}
	
	
	@Override
	public String getId() {
	    return id;
	}
	
	@Override
	public void setId(String id) {
	    this.id = id;
	}
    
    @Override
    public int getWidth() {
        return getDimension().getWidth();
    }

    @Override
    public int getHeight() {
        return getDimension().getHeight();
    }
    
    @Override
    public Shape getShape() {
        return new BasicRectangleShape(getDimension().getWidth(), getDimension().getHeight());
    }
    
    @Override
    public String toString() {
        return "[Factory] " + super.toString();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Collection<Figure> getFigures() {
        return (Collection) getComponents();
    }
    
    
    @Override
    public void behave() {
    	for (Component component : getComponents()) {
    		component.behave();
    	}
    }
    
    @Override
    public boolean addObserver(Observer observer) {
        return getObservers().add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return getObservers().remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : getObservers()) {
            observer.modelChanged();
        }
    }
    
    @Override
    public boolean addComponent(Component component) {
        boolean added = super.addComponent(component);
        if (added) {
            component.setFactory(this);
        }
        return added;
    }
    
    public boolean isSimulationRunning() {
        return simulationRunning;
    }
    
    public void stopSimulation() {
        simulationRunning = false;
        notifyObservers();
    }
    
    
    public void startSimulation() {
        simulationRunning = true;
        notifyObservers();
        
        while (simulationRunning) {
            behave();
            
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private Set<Observer> getObservers() {
        if (observers == null) {
            observers = new HashSet<Observer>();
        }
        return observers;
    }
    
}