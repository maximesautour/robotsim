package fr.tp.robotsim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CompositeComponent extends Component implements Serializable {

    private final List<Component> components;
    public static final long serialVersionUID = 202605071940L;

    public CompositeComponent(String name, Position position, Dimension dimension) {
        super(name, position, dimension);
        this.components = new ArrayList<Component>();
    }

    public List<Component> getComponents() {
        return components;
    }

    private boolean checkComponentName(String name) {
        for (Component component : components) {
            if (component.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean addComponent(Component component) {
        if (!checkComponentName(component.getName())) {
            return false;
        }
        components.add(component);
        component.setFactory(this.getFactory());
        return true;
    }

    @Override
    public String toString() {
        String result = super.toString() + " containing:\n";
        for (Component component : components) {
            result = result + "  - " + component + "\n";
        }
        return result;
    }
}