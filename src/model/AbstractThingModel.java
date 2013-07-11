package model;

/**
 * @author Fabian Sörensson & Anton Bergman
 * This is the super-class for all things in the model that also has a 
 * representation in the view, e.g. the cursor or the player character.
 */
public abstract class AbstractThingModel implements ThingModelInterface {

	protected int x, y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
}
