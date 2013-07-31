package view;

import model.*;
import model.ThingState;

import org.lwjgl.input.Mouse;

import controller.CursorM;

public class CursorV extends AbstractThingView {
	
	private CursorM model;
	
	public CursorV(CursorM model) {
		super(model);
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
}
