package model;

import java.util.HashMap;

public class PlayerModel extends AbstractEntityModel implements EntityModelInterface {
	
	private final double walkingSpeed = .11; // detta tal är cray på grund av delta-grejen
	private double destinationX;
	private double destinationY;
	private boolean walking; 
	private InteractableInterface targetInteractable;
	private boolean reachedTarget;
	private Event event;
	
	public PlayerModel(double x, double y, int width, int height, HashMap<ThingState, String> stateImageMap) {
		super(x, y, width, height, stateImageMap);
		// olol
		destinationX = 0;
		destinationY = 0;
		walking = false;
		targetInteractable = null;
		state = ThingState.DEFAULT;
	}
	
	/**
	 * @param delta The timer delta
	 * 
	 * This method will be used for every iteration of the game loop as long as the player should be walking.
	 */
	public void walk(int delta) {
		
		// Calculate where the player actually stands, not where he is drawn
		double standX = x + (width / 2);
		double standY = y - height;
		
		// Calculate the x and y distances to the destination.
		double distanceX = destinationX - standX;
		double distanceY = destinationY - standY;
		
		// Calculate dx and dy
		double walkingProp = walkingSpeed / 
				Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));		
		double dX = walkingProp * distanceX;
		double dY = walkingProp * distanceY;
		
		// Add the timer delta (TODO: kanske ganska jävla onödigt)
		x += dX * delta;
		y += dY * delta;
		
		// Han hamnar aldrig exakt där man vill... men det fungerar någorlunda bra
		// Så som det är nu så är det fel: om frameraten skulle vara högre så skulle
		// han hamna på fel ställe.
		
		// See if the player has reached its destination. If so, tell the player to stop walking.
		if ((standX < destinationX + 1 && standX > destinationX - 1) && 
				(standY < destinationY + 1 && standY > destinationY - 1)) {
			walking = false;
			
			// Check if the user clicked an interactable for the player to walk to.
			// If the user did, fetch the correct event from the interactable.
			// If not, targetInteractable will be null and no more will be done.
			if (this.targetInteractable != null) {
				reachedTarget = true;
				event =	this.targetInteractable.clicked(); // När olika handlingar 
				// (hacka, plocka grejer, använda inventariesaker) väl finns måste dessa skickas med här	
			}
		}
	}

	
	/**
	 * @param playerDestinationX The destination x coordinate
	 * @param playerDestinationY The destination y coordinate
	 * @param targetInteractable The interactable that the player is walking to 
	 * (null if the player is not walking to an interactable)
	 * 
	 * This method is used by the model if the user has clicked somewhere and the 
	 * player should start walking there. If so, the method walk() will be called for every iteration
	 * of the game loop until the player has reached the destination.
	 */
	public void startWalking(int playerDestinationX, int playerDestinationY, 
			InteractableInterface targetInteractable) {
		destinationX = playerDestinationX;
		destinationY = playerDestinationY;
		walking = true;
		
		// Set the interactable that the player is walking to. If no interactable was clicked, this will be null.
		this.targetInteractable = targetInteractable;
	}
	
	/**
	 * @return if the player should be walking
	 */
	public boolean isWalking() {
		return walking;
	}
	
	/**
	 * @return if the player has reached the target interactable
	 */
	public boolean hasReachedTarget() {
		return reachedTarget;
	}
	
	/**
	 * @return the event from the target interactable (will be done if it is reached)
	 */
	public Event getEvent() {
		return event;
	}
}
