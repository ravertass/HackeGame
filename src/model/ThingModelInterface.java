package model;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This is the interface for all things in the model that will also have
 * a representation in the view.
 */
public interface ThingModelInterface {
	public double getX();
	public double getY();
	public void update();
	public ThingState getState();
	public void changeState(ThingState state);
}
