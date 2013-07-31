package view;

import model.AbstractEntityModel;

public class PlayerView extends AbstractThingView {

	public PlayerView(AbstractEntityModel model) {
		super(model);
	}
	
	public void draw() {
		x = (int) model.getX();
		y = (int) model.getY();
		super.draw();
	}
}
