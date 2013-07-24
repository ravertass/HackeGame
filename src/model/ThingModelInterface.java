package model;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This is the interface for all things in the model that will also have
 * a representation in the view.
 */
public interface ThingModelInterface {
<<<<<<< HEAD
	public int getX();
	public int getY();
	public int getHeight();
	public int getWidth();
=======
	public double getX();
	public double getY();
>>>>>>> 17e2bbc52a5decc08b8ee9e49dd12082094d66e9
	public void update();
	public ThingState getState();
	public void changeState(ThingState state);
}
