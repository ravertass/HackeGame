package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This is the interface for all things in the model that will also have
 * a representation in the view.
 */
public interface EntityModelInterface {
    public int getHeight();
    public int getWidth();
    public double getX();
    public double getY();
    public ThingState getState();
    public void changeState(ThingState state);
    public HashMap<ThingState, String> getImages();
	public boolean exists();
}