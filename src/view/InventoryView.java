package view;

import java.util.ArrayList;

import model.InventoryModel;
import model.InventoryThingModel;
import model.StateThingModel;

public class InventoryView extends AbstractThingView {

	private ArrayList<ThingView> thingsInInventory;
	private InventoryModel model;
	
	public InventoryView(double x, double y, int width, int height,
			String imageName, InventoryModel model) {
		super(x, y, width, height, imageName, model);
		this.model = model;
		thingsInInventory = new ArrayList<ThingView>();
		// lägg till alla saker i listan
		// sätt sakernas x- och y-värden relativa till InventoryViewn
	}
	
	public void draw() {
		// Kolla: Finns det något nytt i inventory-modellen?
		if (model.changed()) {
			InventoryThingModel thingModel = model.getLast();
			ThingView pokeflute = new ThingView(16, 464, 32, 32, "pokeflute", thingModel);
			thingsInInventory.add(pokeflute);
		}
		// I så fall: Lägg till detta i inventory-viewn
		super.draw();
		for (ThingView thing : thingsInInventory) {
			thing.draw();
		}
	}

}
