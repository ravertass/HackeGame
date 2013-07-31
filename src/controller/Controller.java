package controller;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import view.View;
import model.InteractableInterface;
import model.Model;
import model.ThingState;

/**
 * 
 * @author Fabian S�rensson & Anton Bergman
 *
 * This is the controller class. It handles user input from the mouse and the keyboard.
 * The code follows the Model-View-Controller design pattern.
 *
 */

public class Controller {

	private Model model;
	private int mouseX, mouseY;
	private boolean gameIsRunning;
	private boolean leftClick;
	private boolean rightClick;
	private CursorM cursor;
	
	// Det är tänkbart att vi så småningom arrar en egen klass för controller-representationen av
	// interactables, istället för att använda model-representationen såhär,
	// men för tillfället ser vi inget bra skäl till att göra så
	private ArrayList<InteractableInterface> interactablesInRoom;
	
	/**
	 * Initializes the controller
	 */
	public Controller(Model model) {
		this.model = model;
		gameIsRunning = true;
		cursor = new CursorM();
	}

	/**
	 * @return the cursor
	 * This method exists so the view can get access to the cursor
	 */
	public CursorM getCursor() {
		return cursor;
	}
	
	/**
	 * This method handles all the user input
	 * For now, we're not quite sure of how the input will be forwarded to
	 * view/model
	 */
	private void input() {
		// Get cursor coordinates from the mouse
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || 
				Display.isCloseRequested()) {
			gameIsRunning = false;
		}
		
		if (Mouse.isButtonDown(0)) {
			leftClick = true;
		}
		if (Mouse.isButtonDown(1)) {
			rightClick = true;
		}
	}

	// Used by the main app to see if the user tries to exit the game
	public boolean continueRunning() {
		return gameIsRunning;
	}

	// Run for every iteration of the main loop in the main app
	public void update() {
		// Reset the mouse button click-flags
		leftClick = false;
		rightClick = false;
		
		input();
		
		// Check if the player has entered a new room
		if (model.hasRoomChanged()) {
			// Get all the new interactables
			interactablesInRoom = model.getActiveRoom().getInteractables();
		}

		if (leftClick) {
			// Tell the model that the user has clicked on certain coordinates
			// and that the player should probably go there
			model.setPlayerCoordinates(mouseX, mouseY);
			
			// Check through the list of active interactables if the player has clicked
			// any of them: If so, tell the model which interactable is clicked
			checkInteractables();
		}
		
		// Tell the cursor representation the new mouse coordinates
		cursor.update(mouseX, mouseY);
	}

	/**
	 * This method is used to iterate through the list of interactables in the active room
	 * and check if the cursor hovers over any of them (i.e. if the user has clicked on any of them)
	 * and if so tells the model which one is clicked
	 */
	private void checkInteractables() {
		for (InteractableInterface interactable : interactablesInRoom) {
			if (mouseX > interactable.getX() && mouseX < (interactable.getX() + interactable.getWidth())
					&& mouseY < interactable.getY() && mouseY > (interactable.getY() - interactable.getHeight())) {
				cursor.changeState(ThingState.CURSOR_INTERACT);
				if (leftClick) {
					// Tell the model which interactable is clicked
					// (this will be reset for every iteration of the main loop)
					model.setClickedInteractable(interactable);
				}
			}
		}
	}
	
}
