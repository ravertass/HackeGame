package model;

import org.lwjgl.input.Mouse;

/**
 * @author Fabian Sörensson & Anton Bergman
 * This class handles the logic for the game cursor.
 */
public class CursorM extends AbstractThingModel {
	
	public CursorM() {
		// lol
	}

	// This method will be run by the model for every instance of the game loop
	public void update() {
		x = Mouse.getX();
		y = Mouse.getY();
	}
}
