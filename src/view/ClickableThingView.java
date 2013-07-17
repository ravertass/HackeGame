package view;

import model.*;

/**
 * @author Fabian Sörensson & Anton Bergman
 *	Class for clickable things in the game world. 
 *	Another class calls the method clicked() and something happens.
 */

public class ClickableThingView extends AbstractThingView {
	
	private ClickableThingModel model;
	
	public ClickableThingView(int x, int y, int width, int height, String imageName, 
			ClickableThingModel model) {
		super(x, y, width, height, imageName, model);
		this.model = model;
	}
	
	public void draw() {
		if (model.getState().equals(ThingState.SNORLAX_SLEEPING)) {
			super.setImage("snorlax_0");
		} else {
			super.setImage("snorlax_1");	
		}
		super.draw();
	}
}
