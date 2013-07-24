package model;


public class ClickableThingModel extends AbstractThingModel {
	
	private ThingState state;
	
	public ClickableThingModel(int x, int y, int width, int height) {
		super(x, y, width, height);
		state = ThingState.SNORLAX_SLEEPING;
	}

	@Override
	public void update() {
		// Do nothing
	}

	public void clicked() {
		if (state == ThingState.SNORLAX_SLEEPING) {
			state = ThingState.SNORLAX_AWAKE;
		}
	}
	
	public ThingState getState() {
		return state;
	}
}
