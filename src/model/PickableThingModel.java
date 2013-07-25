package model;

public class PickableThingModel extends AbstractThingModel implements ClickableThingInterface {
	
	private boolean exists;
	
	public PickableThingModel(int x, int y, int width, int height) {
		super(x, y, width, height);
		exists = true;
	}

	@Override
	public void update() {
		
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
