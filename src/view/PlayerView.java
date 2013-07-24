package view;

import model.AbstractThingModel;

public class PlayerView extends AbstractThingView {

	public PlayerView(int x, int y, int width, int height, String imageName,
			AbstractThingModel model) {
		super(x, y, width, height, imageName, model);
	}
	
	public void draw() {
		x = (int) model.getX();
		y = (int) model.getY();
		super.draw();
	}
}
