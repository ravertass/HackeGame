package model;

public class PickableThingModel extends AbstractThingModel implements ClickableThingInterface {
	
	public PickableThingModel(int x, int y, int width, int height){
		super(x, y, width, height);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void clicked() {
		// Lägga till saken i inventory
		InventoryThingModel thing = new InventoryThingModel(this);
		// inventory.add(thing);
		// Ta bort saken
	}
}
