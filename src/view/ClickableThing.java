package view;

import model.*;


/**
 * @author Fabian Sörensson & Anton Bergman
 *	Class for clickable things in the game world. 
 *	Another class calls the method clicked() and something happens.
 */

public class ClickableThing extends AbstractThingView{
	
	public ClickableThing(int x, int y, int width, int height, String imageName, ClickableThingModel model) {
		super(x, y, width, height, imageName, model);
	}
	
	//Reacts and does some kind of event when clicked on
	public void clicked() {
		setImage("snorlax_1");
	}
	
}
