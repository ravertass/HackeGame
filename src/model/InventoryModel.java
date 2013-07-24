package model;

import java.util.*;

public class InventoryModel {
	
	private ArrayList<InventoryThingModel> inventory;
	
	public void add(InventoryThingModel item){
		inventory.add(item);
	}
	
	// Remove kanske behöver returna saken också
	public void remove(InventoryThingModel item){
		inventory.remove(item);
	}
	
	
}
