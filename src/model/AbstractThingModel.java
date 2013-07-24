package model;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This is the super-class for all things in the model that also has a 
 * representation in the view, e.g. the cursor or the player character.
 */
public abstract class AbstractThingModel implements ThingModelInterface {

	protected int x, y, width, height;
	protected ThingState state;
	
	public AbstractThingModel(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public ThingState getState() {
		return state;
	}
	
	public void changeState(ThingState state) {
		this.state = state;
	}
}
