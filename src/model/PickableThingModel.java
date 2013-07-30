package model;

public class PickableThingModel extends AbstractEntityModel implements InteractableInterface {
	
	private boolean exists;
	
	public PickableThingModel(int x, int y, int width, int height) {
		super(x, y, width, height);
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
