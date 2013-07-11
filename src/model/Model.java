package model;

/**
 * @author Fabian S�rensson & Anton Bergman
 *
 * This is the model class.
 * The code follows the Model-View-Controller design pattern.
 * The model class handles all the game logic and is essentially unaware of
 * the view and the controller.
 */
public class Model {

	public CursorM cursor;
	
	public Model() {
		cursor = new CursorM();
	}
	
	public void update() {
		cursor.update();
	}
}
