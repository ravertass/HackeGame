package model;

import java.util.ArrayList;

import controller.CursorM;

/**
 * @author Fabian Sörensson & Anton Bergman
 *
 * This is the model class.
 * The code follows the Model-View-Controller design pattern.
 * The model class handles all the game logic and is essentially unaware of
 * the view and the controller.
 */
public class Model {

	public PlayerModel player;
	public InventoryModel inventory; //Borde kanske inte vara publik?
	private Timer timer;
	private Room activeRoom;
	private boolean roomChanged; // Flag that checks if the room is changed (for the v&c)
	private InteractableInterface clickedInteractable;
	
	private boolean playerStartWalking;
	private int playerDestinationX;
	private int playerDestinationY;
	
	public Model() {
		//Gammalt
		timer = new Timer();
		inventory = new InventoryModel();
		
		playerStartWalking = false;
	}
	
	/**
	 * @return the flag to check if a new room has been instantiated, used by the v&c
	 */
	public boolean hasRoomChanged() {
		return roomChanged;
	}
	
	/**
	 * This method will be run for every iteration of the main game loop.
	 */
	public void update() {
		// Om vi skapas flera flaggor av denna sort är det ju gött att ha en metod återställer alla flaggor
		roomChanged = false; // Resets the roomChanged flag
		clickedInteractable = null; // Reset the clicked interactable
		
		// Tillfällig kod för att initiera testrummet och sätta roomChanged-flaggan till true första gången
		// Det här kommer råförsvinna när vi börjar med XML
		if (activeRoom == null) {
			// Tillfälligt de interactables som finns i testrummet
			ArrayList<InteractableInterface> interactablesInRoom;
			StateThingModel snorlax = new StateThingModel(128, 128, 64, 64);
			PickableThingModel pokeflute = new PickableThingModel(380, 100, 32, 32);
			
			// Initiera testrummet, sätt till aktivt rum
			// Rum kommer att genereras av en XML-generator sedan, istället för att definieras 
			// på det här viset direkt i koden
			activeRoom = new Room(interactablesInRoom, "bg_chalmers");
			player = new PlayerModel(256, 96, mouseX, mouseX);
			
			roomChanged = true;
		}
		
		//Tidsgrejerna är frågan, behövs de?
		int delta = timer.getDelta();
		
		// Gamla grejer
		// (jättefult att player.update() skulle returnera ett event)
		// Det nya som gäller: Spelaren ska endast gå om playerStartWalking är sant
		Event event = player.update(mouseX, mouseY, leftClick, delta, targetThing);
		
		// Gamla grejer
		inventory.update();
		
		// Gamla grejer
		// Det här känns som någon ful, tillfällig kod
		if (event != null) {
			inventory.add(new InventoryThingModel(event.getThing()));
			thingsInRoom.remove(event.getThing());
		}
		
		// Om vi skapas flera flaggor av denna sort är det ju gött att ha en metod återställer alla flaggor
		playerStartWalking = false; // Reset the flag that tells if the player should start walking
	}

	// So the v&c can get access to the active room
	public Room getActiveRoom() {
		return activeRoom;
	}
	
	/**
	 * @param clickedInteractable
	 * The controller uses this method to set which interactable is clicked
	 */
	public void setClickedInteractable(InteractableInterface clickedInteractable) {
		this.clickedInteractable = clickedInteractable;
	}

	/**
	 * @param mouseX
	 * @param mouseY
	 * This method is used by the controller to tell the model that the mouse has been clicked
	 * and the player should probably start walking.
	 */
	public void setPlayerCoordinates(int x, int y) {
		// I denna metod kommer vi antagligen så småningom ha logik som kollar om spelaren verkligen ska gå till
		// ett specifikt ställe (eller så kommer det finnas i update(), vi får la se)
		
		// Set a flag that tells us that the mouse has been clicked and the player should start walking
		playerStartWalking = true;
		playerDestinationX = x;
		playerDestinationY = y;
	}
}
