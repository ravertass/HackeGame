package controller;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import view.View;
import model.Model;

/**
 * 
 * @author Fabian S�rensson & Anton Bergman
 *
 * This is the controller class.
 * The code follows the Model-View-Controller design pattern.
 * This controller class contains the main loop for the game and it manages the
 * relation between the Model class and the View class.
 * It also contains a main method.
 *
 */

public class Controller {

	private View view;
	private Model model;
	private boolean isRunning;
	
	/**
	 * @param args : No arguments
	 */
	public static void main(String[] args) {
		new Controller();
	}
	
	/**
	 * This constructor creates the model and view instances.
	 * It also consists of the main loop.
	 */
	public Controller() {
		model = new Model();
		view = new View(model);
		
		isRunning = true;
		
		while (isRunning) {
			// input() only lets the player exit the game for now
			input();
			// Tell the model to update all game logic
			model.update();
			// Tell the view to update and redraw everything
			view.update();
		}
		
		Display.destroy();
		System.exit(0);
	}

	/**
	 * This method handles all the user input
	 * For now, we're not quite sure of how the input will be forwarded to
	 * view/model
	 */
	private void input() {
		// 
		model.setMouseX(Mouse.getX());
		model.setMouseY(Mouse.getY());
		
		// This could very well turn out to be unnecessary.
		// We are right now confused about if the view or the model should take
		// the input information...
		view.setMouseX(Mouse.getX());
		view.setMouseY(Mouse.getY());
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || 
				Display.isCloseRequested()) {
			isRunning = false;
		}
		
		if (Mouse.isButtonDown(0)) {
			model.leftClick();
			// This, too, could be unnecessary/wrong
			view.leftClick();
		}
		if (Mouse.isButtonDown(1)) {
			model.rightClick();
			// This, too, could be unnecessary/wrong
			view.rightClick();
		}
	}
	
}
