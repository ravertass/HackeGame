package model;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This is the interface for all things in the model that will also have
 * a representation in the view.
 */
public interface ThingModelInterface {
	public int getX();
	public int getY();
	public int getHeight();
	public int getWidth();
	public void update();
	public ThingState getState();
	public void changeState(ThingState state);
}
