package model;

import java.util.ArrayList;

/**
 * @author Fabian Sörensson & Anton Bergman
 *
 * This is the model class.
 * The code follows the Model-View-Controller design pattern.
 * The model class handles all the game logic and is essentially unaware of
 * the view and the controller.
 */
public class Model {

	public CursorM cursor;
	public ArrayList<ClickableThingInterface> thingsInRoom;
	public PlayerModel player;
	private int mouseX, mouseY;
	private boolean leftClick, rightClick;
	
	public Model() {
		thingsInRoom = new ArrayList<ClickableThingInterface>();
		cursor = new CursorM();
		mouseX = 50;
		mouseY = 50;
		leftClick = false;
		rightClick = false;
		StateThingModel snorlax = new StateThingModel(128, 128, 64, 64);
		player = new PlayerModel(256, 96, mouseX, mouseX);
		thingsInRoom.add(snorlax);
	}
	
	/**
	 * This method will be run for every iteration of the main game loop.
	 */
	public void update() {
		cursor.update(mouseX, mouseY);
		cursor.changeState(ThingState.MOUSE_DEFAULT);
		
		ClickableThingInterface targetThing = null;
		
		for (ClickableThingInterface thing : thingsInRoom) {
			if (mouseX > thing.getX() && mouseX < (thing.getX() + thing.getWidth())
					&& mouseY < thing.getY() && mouseY > (thing.getY() - thing.getHeight())) {
				cursor.changeState(ThingState.MOUSE_INTERACT);
				if (leftClick) {
					targetThing = thing;
				}
			}
		}
		
		player.update(mouseX, mouseY, leftClick, targetThing);
		
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
