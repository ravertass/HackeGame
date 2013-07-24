package view;

import model.CursorM;
import model.ThingState;

import org.lwjgl.input.Mouse;

public class CursorV extends AbstractThingView {
	
	private CursorM model;
	
	public CursorV(int x, int y, int width, int height, CursorM model) {
		super(x, y, width, height, "cursor_0", model);
		this.model = model;
		Mouse.setGrabbed(true);
	}
	
	public void draw() {
		if (model.getState().equals(ThingState.MOUSE_INTERACT)) {
			super.setImage("cursor_2");
		} else {
			super.setImage("cursor_0");
		}
		x = model.getX();
		y = model.getY();
		super.draw();
	}
	
	public CursorV(CursorM model) {
		this(50, 50, 32, 32, model);
	}
}
