package view;

import model.AbstractThingModel;

public class PlayerView extends AbstractThingView {

	public PlayerView(int x, int y, int width, int height, String imageName,
			AbstractThingModel model) {
		super(x, y, width, height, imageName, model);
	}
	
	public void draw() {
		x = model.getX();
		y = model.getY();
		super.draw();
	}
}
