package model;


public class StateThingModel extends AbstractThingModel implements ClickableThingInterface{
	
	private ThingState state;
	
	public StateThingModel(int x, int y, int width, int height) {
		super(x, y, width, height);
		state = ThingState.FIRST_IMAGE;
	}

	@Override
	public void update() {
		// Do nothing
	}

	public void clicked() {
		if (state == ThingState.FIRST_IMAGE) {
			state = ThingState.SECOND_IMAGE;
		}
	}
	
	public ThingState getState() {
		return state;
	}
}
