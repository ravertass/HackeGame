package controller;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import view.View;
import model.Model;

/**
 * 
 * @author Fabian Sörensson & Anton Bergman
 *
 * This is the controller class for our test game, Project Xtreme.
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
	
	public Controller() {
		view = new View();
		model = new Model();
		
		isRunning = true;
		
		while (isRunning) {
			input();
			model.update();
			view.update();
		}
		
		Display.destroy();
		System.exit(0);
	}

	private void input() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || 
				Display.isCloseRequested()) {
			isRunning = false;
		}
	}
	
}
