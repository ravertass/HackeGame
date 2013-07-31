package main;

import org.lwjgl.opengl.Display;

import controller.Controller;
import model.Model;
import view.View;

public class MainApplication {
	private Model model;
	private View view;
	private Controller controller;
	private boolean isRunning;
	
	public static void main(String[] args) {
		new MainApplication();
	}
	
	public MainApplication() {
		model = new Model();
		controller = new Controller(model); //Även view?
		view = new View(model, controller.getCursor());
		
		isRunning = true;
		
		while (isRunning) {
			// Tell the controller to check for input 
			controller.update();
			// Tell the model to update all game logic
			model.update();
			// Tell the view to update and redraw everything
			view.update();
			
			// Check with the controller if the user has tried to exit the game
			isRunning = controller.continueRunning();
		}
		
		Display.destroy();
		System.exit(0);
	}

}
