package controller;

import java.util.HashMap;

import model.AbstractEntityModel;
import model.ThingState;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This class handles the logic for the game cursor.
 * We choose to put this class together with the controller, since the cursor is very specific for a certain
 * controller interface (e.g., an Android implementation would use a touchscreen and therefor not need a cursor).
 */
public class CursorM extends AbstractEntityModel {
	
	public CursorM() {
		super(50, 50, 32, 32, getStateImageMap());
		state = ThingState.CURSOR_DEFAULT;
		// Lägg in koordinater, bredd och höjd 
		// (för tillfället satta till magiska tal från en början, 
		// men dessa kommer för varje iteration av huvudloopen att plockas från faktiska muspositioner)
	}

	private static HashMap<ThingState, String> getStateImageMap() {
		HashMap<ThingState, String> cursorMap = new HashMap<ThingState, String>();
		cursorMap.put(ThingState.CURSOR_DEFAULT, "cursor_0");
		cursorMap.put(ThingState.CURSOR_INTERACT, "cursor_1");
		cursorMap.put(ThingState.CURSOR_PICKUP, "cursor_2");
		return cursorMap;
	}

	// This method will be run by the controller for every instance of the game loop
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
