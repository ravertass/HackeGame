package view;

import org.lwjgl.input.Mouse;

public class Cursor extends AbstractGameThing {

	public Cursor(int x, int y, int width, int height) {
		super(x, y, width, height);
		setImage("cursor_0");
		Mouse.setGrabbed(true);
	}
	
	public Cursor() {
		this(50, 50, 32, 32);
	}
}
