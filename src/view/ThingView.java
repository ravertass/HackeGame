package view;

import model.*;

/**
 * @author Fabian Sörensson & Anton Bergman
 *	Class for clickable things in the game world. 
 *	Another class calls the method clicked() and something happens.
 */

public class ThingView extends AbstractThingView {
	
	private AbstractThingModel model;
	private String firstImage, secondImage;
	private boolean remove;
	
	public ThingView(int x, int y, int width, int height, String firstImage, 
			String secondImage, StateThingModel stateThingModel) {
		super(x, y, width, height, firstImage, stateThingModel);
		this.firstImage = firstImage;
		this.secondImage = secondImage;
		this.model = stateThingModel;
	}
	
	public ThingView(int x, int y, int width, int height, String firstImage, 
			PickableThingModel pickableThingModel) {
		super(x, y, width, height, firstImage, pickableThingModel);
		this.firstImage = firstImage;
		this.secondImage = null;
		this.model = pickableThingModel;
	}
	
	public ThingView(int x, int y, int width, int height, String firstImage, 
			InventoryThingModel inventoryThingModel) {
		super(x, y, width, height, firstImage, inventoryThingModel);
		this.firstImage = firstImage;
		this.secondImage = null;
		this.model = inventoryThingModel;
	}
	
	public void draw() {
		if (model instanceof StateThingModel) {
			if (model.getState().equals(ThingState.FIRST_IMAGE)) {
				super.setImage(firstImage);
			} else if (model.getState().equals(ThingState.SECOND_IMAGE)) {
				super.setImage(secondImage);	
			}
		} else if (model instanceof PickableThingModel) {
			if (!((PickableThingModel) model).exists()) {
				remove = true;
			}
		}
		
		super.draw();
	}
	
	public boolean shouldRemove() {
		return remove;
	}
}
