package model;

import java.util.*;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This is the super-class for all things in the model that also has a 
 * representation in the view, e.g. the cursor or the player character.
 */
public abstract class AbstractEntityModel implements EntityModelInterface {

	protected double x, y;
	protected int width, height;
	protected ThingState state;
	protected HashMap<ThingState, String> stateImageMap;
	private boolean exists;
	
	public AbstractEntityModel(double x, double y, int width, int height, 
			HashMap<ThingState, String> stateImageMap) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.stateImageMap = stateImageMap;
		exists = true;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public ThingState getState() {
		assert (state == null) : this.toString() + ": Staten är null"; 
		return state;
	}
	
	public void changeState(ThingState state) {
		this.state = state;
	}
	
	public HashMap<ThingState, String> getImages(){
		return stateImageMap;
	}

	public boolean exists() {
		return exists;
	}
}
