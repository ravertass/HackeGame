package view;

import model.AbstractThingModel;
import model.ThingState;

public class PlayerView extends AbstractThingView {

	public PlayerView(int x, int y, int width, int height, String imageName,
			AbstractThingModel model) {
		super(x, y, width, height, imageName, model);
	}
	
	public void draw() {
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		x = model.getX();
		y = model.getY();
		super.draw();
	}
}
