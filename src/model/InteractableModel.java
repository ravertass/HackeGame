package model;

import java.util.HashMap;

/**
 * @author fabian & anton
 * This class will be used for _all_ interactables in the game.
 * What will actually make them differ will be the images in the stateImageMap,
 * and the events in the stateActionEventMap. All logic that makes them different will
 * be defined in the different events.
 */
public class InteractableModel extends AbstractEntityModel implements InteractableInterface {

	private boolean exists;
	private HashMap<StateAndAction, Event> stateActionEventMap;

	public InteractableModel(double x, double y, int width, int height,
			HashMap<ThingState, String> stateImageMap, HashMap<StateAndAction, Event> stateActionEventMap) {
		super(x, y, width, height, stateImageMap);
		this.stateActionEventMap = stateActionEventMap;
	}

	@Override
	public Event clicked(ActionType action) {
		// Använd action-parametern, samt interactablens nuvarande state,
		// i stateActionEventMapen för att lista ut vilket event som
		// 1) ska användas av en InteractableEventHandler
		// och 2) ska returneras för att kunna användas av modellens EventHandler
		return null;
	}
	
	public boolean exists() {
		return exists;
	}
}
