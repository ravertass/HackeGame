package view;

import model.CursorM;

import org.lwjgl.input.Mouse;

public class CursorV extends AbstractGameThing {

	private CursorM model;
	
	public CursorV(int x, int y, int width, int height, CursorM model) {
		super(x, y, width, height);
		this.model = model;
		setImage("cursor_0");
		Mouse.setGrabbed(true);
	}
	
	public void draw() {
		x = model.getX();
		y = model.getY();
		super.draw();
	}
	
	public CursorV(CursorM model) {
		this(50, 50, 32, 32, model);
	}
}