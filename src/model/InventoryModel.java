package model;

import java.util.*;

public class InventoryModel extends AbstractEntityModel {
	
	public ArrayList<InventoryThingModel> inventory; //publik tills vidare...
	private boolean changed;
	
	public InventoryModel() {
		super(0, 0, 100, 100); //dessa siffror tills vidare
		changed = false;
		inventory = new ArrayList<InventoryThingModel>();
	}
	
	public void add(InventoryThingModel item) {
		changed = true;
		inventory.add(item);
	}
	
	public InventoryThingModel get(int index) {
		return inventory.get(index);
	}
	
	public InventoryThingModel getLast() {
		return inventory.get(inventory.size() - 1);
	}
	
	// Remove kanske behöver returna saken också
	public void remove(InventoryThingModel item) {
		inventory.remove(item);
	}

	public boolean changed() {
		return changed;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		changed = false;
	}
	
	
}
