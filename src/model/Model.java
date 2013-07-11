package model;

/**
 * @author Fabian Sï¿½rensson & Anton Bergman
 *
 * This is the model class.
 * The code follows the Model-View-Controller design pattern.
 * The model class handles all the game logic and is essentially unaware of
 * the view and the controller.
 */
public class Model {

	public CursorM cursor;
	private int mouseX, mouseY;
	private boolean leftClick, rightClick;
	
	public Model() {
		cursor = new CursorM();
	}
	
	/**
	 * This method will be run for every iteration of the main game loop.
	 */
	public void update() {
		cursor.update(mouseX, mouseY);
		/**if leftClick:
			for grejer in arraylist:
				if man har klickat på grejen:
					grej.clicked();**/
		// reset mouse clicks
		leftClick = false;
		rightClick = false;
	}

	public void setMouseX(int x) {
		mouseX = x;
	}

	public void setMouseY(int y) {
		mouseY = y;
	}
	
	/**
	 * This method will be run if the left mouse button is clicked, to let
	 * the model know that it's so.
	 */
	public void leftClick() {
		leftClick = true;
	}

	/**
	 * This method will be run if the right mouse button is clicked, to let
	 * the model know that it's so.
	 */
	public void rightClick() {
		rightClick = true;
	}
}
