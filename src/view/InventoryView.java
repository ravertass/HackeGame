package view;

import java.util.ArrayList;

import model.AbstractEntityModel;
import model.InventoryModel;
import model.InventoryThingModel;
import model.StateThingModel;

public class InventoryView extends EntityView {

	private ArrayList<EntityView> thingsInInventory;
	private InventoryModel model;
	
	public InventoryView(InventoryModel model) { 
		super(model);
		this.model = model;
		thingsInInventory = new ArrayList<EntityView>();
		// lägg till alla saker i listan
		// sätt sakernas x- och y-värden relativa till InventoryViewn
	}
	
	public void update() {
		// Kolla: Finns det något nytt i inventory-modellen?
		if (model.changed()) {
			InventoryThingModel thingModel = model.getLast();
			//EntityView pokeflute = new EntityView(16, 464, 32, 32, "pokeflute", thingModel);
			//thingsInInventory.add(pokeflute);
		}
		// I så fall: Lägg till detta i inventory-viewn
		super.update();
		for (EntityView thing : thingsInInventory) {
			thing.update();
		}
	}

}
