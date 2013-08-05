package model;

/**
 * @author fabian & anton
 * This class is just a tuple for thingStates and actionTypes, used in a map that determines which
 * combination of thingState and actionType will lead to what event.
 */
public class StateAndAction {
	public ThingState thingState;
	public ActionType actionType; 
	
	public StateAndAction(ThingState thingState, ActionType actionType) {
		this.thingState = thingState;
		this.actionType = actionType; 
	}
}
