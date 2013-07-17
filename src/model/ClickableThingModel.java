package model;

<<<<<<< HEAD
public abstract class ClickableThingModel extends AbstractThingModel{
	
	
	public void clicked(){
		
=======
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
>>>>>>> fe679c2f1ba59becc8f7490d017b2a68321b71cf
	}
}
