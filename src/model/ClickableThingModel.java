package model;

<<<<<<< HEAD
public abstract class ClickableThingModel extends AbstractThingModel {
	
	private State state;
	
	private enum State {
		SLEEPING,
		AWAKE
=======
public class ClickableThingModel extends AbstractThingModel {
	
	private ThingState state;
	
	public ClickableThingModel(int x, int y, int width, int height) {
		super(x, y, width, height);
		state = ThingState.SNORLAX_SLEEPING;
>>>>>>> 54cb9a194b623f56e6a874b8a9cb564b92d2cedd
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
