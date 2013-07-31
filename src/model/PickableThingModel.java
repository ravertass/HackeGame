package model;

import java.util.HashMap;

public class PickableThingModel extends AbstractEntityModel implements InteractableInterface {
	
	private boolean exists;
	
	public PickableThingModel(int x, int y, int width, int height, HashMap<ThingState, String> stateImageMap) {
		super(x, y, width, height, stateImageMap);
		exists = true;
	}
	
	public boolean exists() {
		return exists;
	}

	@Override
	public Event clicked() {
		// Lägga till saken i inventory
		exists = false;
		Event event = new Event(this);
		return event;
	}
}
