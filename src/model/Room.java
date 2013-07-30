package model;

import java.util.ArrayList;

/**
 * @author sfabian & bergman
 *
 * Denna klass modellerar ett rum i spelet. Den innehåller allt ett rum kan tänkas göra: Alla interaktiva
 * saker (interactables), såsom upplockbara saker, saker att titta på, personer att snacka med och så vidare.
 * Även Alla polygonvägar för A*-algoritmen, samt utgångar till andra rum (om inte de modelleras som interactables).
 * Innehåller också bakgrundsbilden för rummet.
 *
 */
public class Room {

	private ArrayList<InteractableInterface> interactables;
	private String backgroundImageName;
	
	// polygonvägar för a*-algoritmen kommer ligga här
	// vägar till andra rum kommer även ligga här (om de inte rent av går in under interactables)
	
	/**
	 * @param interactables Alla saker som ska finnas i rummet
	 * @param backgroundImageName Filnamnet på rummets bakgrundsbild
	 * TODO: @param polygonvägar Alla polygonvägar för A* som ska finnas i rummet
	 * TODO: @param exits Utgångar till andra rum (om de inte ingår i interactables?)
	 * Denna constructor kommer i första hand kallas med info från XML-generatorn 
	 * (alternativt skapar vi en constructor som tar info från XML-generatorn själv)
	 */
	public Room(ArrayList<InteractableInterface> interactables, String backgroundImageName) { 
		this.interactables = interactables;
		this.backgroundImageName = backgroundImageName;
		// lägg till polygonvägar
		// lägg till utgångar (kanske)
		
		// måste även kolla vilken väg spelkaraktären kom ifrån

		// Kolla i WorldState-klassen om något i rummet har ändrats från grundtillståndet
		
	}
	
	public ArrayList<InteractableInterface> getInteractables() {
		return (ArrayList<InteractableInterface>) interactables.clone();
	}
	
}
