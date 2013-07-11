package model;

public class Model {

	public CursorM cursor;
	
	public Model() {
		cursor = new CursorM();
	}
	
	public void update() {
		cursor.update();
	}
}
