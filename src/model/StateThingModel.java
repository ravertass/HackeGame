package model;


public class StateThingModel extends AbstractEntityModel implements InteractableInterface{
	
	private ThingState state;
	
	public StateThingModel(int x, int y, int width, int height) {
		super(x, y, width, height);
		state = ThingState.FIRST_IMAGE;
	}
	
	public Event clicked() {
		if (state == ThingState.FIRST_IMAGE) {
			state = ThingState.SECOND_IMAGE;
		}
		return null; //TODO
	}
	
	public ThingState getState() {
		return state;
	}
}
