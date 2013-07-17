package model;

public abstract class ClickableThingModel extends AbstractThingModel {
	
	private State state;
	
	private enum State {
		SLEEPING,
		AWAKE
	}
	
	public ClickableThingModel() {
		state = State.SLEEPING;
	}
	
	public void clicked() {
		if (state == State.SLEEPING) {
			state = State.AWAKE;
		}
	}
	
	public State getState() {
		return state;
	}
}
