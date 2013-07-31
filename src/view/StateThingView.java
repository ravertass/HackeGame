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
	
	public StateThingView(StateThingModel stateThingModel) {
		super(stateThingModel);
		this.model = stateThingModel;
		this.firstImage = imageList.get(0);
		this.secondImage = imageList.get(1);
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
