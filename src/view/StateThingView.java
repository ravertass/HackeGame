package view;

import model.*;

/**
 * @author Fabian Sörensson & Anton Bergman
 *	Class for clickable things in the game world. 
 *	Another class calls the method clicked() and something happens.
 */

public class StateThingView extends AbstractThingView {
	
	private StateThingModel model;
	private String firstImage, secondImage;
	
	public StateThingView(int x, int y, int width, int height, String firstImage, 
			String secondImage, StateThingModel stateThingModel) {
		super(x, y, width, height, firstImage, stateThingModel);
		this.firstImage = firstImage;
		this.secondImage = secondImage;
		this.model = stateThingModel;
	}
	
	public void draw() {
		if (model.getState().equals(ThingState.FIRST_IMAGE)) {
			super.setImage(firstImage);
		} else {
			super.setImage(secondImage);	
		}
		super.draw();
	}
}
