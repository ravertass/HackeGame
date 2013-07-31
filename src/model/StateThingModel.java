package model;

import java.util.HashMap;


public class StateThingModel extends AbstractEntityModel implements InteractableInterface{
	
	private ThingState state;
	
	public StateThingModel(int x, int y, int width, int height, HashMap<ThingState, String> stateImageMap) {
		super(x, y, width, height, stateImageMap);
		state = ThingState.SNORLAX_SLEEPING;
	}
	
	public Event clicked() {
		if (state == ThingState.SNORLAX_SLEEPING) {
			state = ThingState.SNORLAX_AWAKE;
		}
		return null; //TODO
	}
	
	public ThingState getState() {
		return state;
	}
}
