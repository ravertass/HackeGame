package model;

import org.lwjgl.input.Mouse;

public class CursorM extends AbstractThingModel {
	
	public CursorM() {
		// lol
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// ber�kna x och y
		x = Mouse.getX();
		y = Mouse.getY();
	}
}
