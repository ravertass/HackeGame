package model;

import java.util.ArrayList;
import java.util.HashMap;

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
		
		// Här initierar vi spelaren och dess bilder
		HashMap<ThingState, String> playerMap = new HashMap<ThingState, String>();
		playerMap.put(ThingState.DEFAULT, "guybrush");
		player = new PlayerModel(256, 96, 32, 64, playerMap);
		
		inventory = new InventoryModel();
		
		clickedInteractable = null;
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
		
		// Tillfällig kod för att initiera testrummet och sätta roomChanged-flaggan till true första gången
		// Det här kommer råförsvinna när vi börjar med XML
		if (activeRoom == null) {
			// Tillfälligt de interactables som finns i testrummet
			ArrayList<InteractableInterface> interactablesInRoom = new ArrayList<InteractableInterface>();
			
			HashMap<ThingState, String> snorlaxMap = new HashMap<ThingState, String>();
			snorlaxMap.put(ThingState.SNORLAX_SLEEPING, "snorlax_0");
			snorlaxMap.put(ThingState.SNORLAX_AWAKE, "snorlax_1");
			StateThingModel snorlax = new StateThingModel(128, 128, 64, 64, snorlaxMap);
			
			HashMap<ThingState, String> pokefluteMap = new HashMap<ThingState, String>();
			pokefluteMap.put(ThingState.DEFAULT, "pokeflute");
			PickableThingModel pokeflute = new PickableThingModel(380, 100, 32, 32, pokefluteMap);
			interactablesInRoom.add(snorlax);
			interactablesInRoom.add(pokeflute);
			pokeflute.changeState(ThingState.DEFAULT);
			
			// Initiera testrummet, sätt till aktivt rum
			// Rum kommer att genereras av en XML-generator sedan, istället för att definieras 
			// på det här viset direkt i koden
			activeRoom = new Room(interactablesInRoom, "bg_chalmers");
			
			roomChanged = true;
		}
		
		//Tidsgrejerna är frågan, behövs de?
		int delta = timer.getDelta();
		
		// Handle all the player's walking logic
		playerWalking(delta);
		
		// Gamla grejer
		//inventory.update();
		
		// Gamla grejer
		// Det här känns som någon ful, tillfällig kod
		/**if (event != null) {
			inventory.add(new InventoryThingModel(event.getThing()));
			thingsInRoom.remove(event.getThing());
		}**/
		
		// Om vi skapas flera flaggor av denna sort är det ju gött att ha en metod återställer alla flaggor
		playerStartWalking = false; // Reset the flag that tells if the player should start walking
		clickedInteractable = null; // Reset the clicked interactable
	}

	/**
	 * @param delta The timer delta
	 * 
	 * The method that handles all the player walking logic
	 */
	private void playerWalking(int delta) {
		// If the controller has told the model that the user has clicked somewhere
		// and the model has deemed that the player should start walking there, (TODO: nu gör den alltid det)
		// tell the player to do so
		if (playerStartWalking) {
			// If the user clicked a certain interactable for the player to interact with,
			// that interactable will be set as the target here as clickedInteractable
			// (and if the user has not, a null will be sent, which is correct)
			player.startWalking(playerDestinationX, playerDestinationY, clickedInteractable);
			
			// TODO: När det väl finns olika sorters handlingar (hacka, häfva, använda inventariegrejer osv) så
			// måste de skickas med här
		}
		
		// If the player should be walking, let him walk
		if (player.isWalking()) {
			player.walk(delta); //högst osäkert om vi verkligen ska köra med den här deltagrejen
			
			// If the player was walking towards an interactable and the target is reached
			if (player.hasReachedTarget()) {
				// Fetch the event from the interactable
				Event event = player.getEvent();
			}
		}
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
	
	// Playern kanske skapas i och med varje rum istället? Vem vet!?
	public PlayerModel getPlayer() {
		return player;
	}
}
