package model;

public class Event {

	private PickableThingModel thing;
	
	public Event(PickableThingModel thing) {
		this.thing = thing;
	}
	
	public PickableThingModel getThing() {
		return thing;
	}
}
