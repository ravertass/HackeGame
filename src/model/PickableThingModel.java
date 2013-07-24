package model;

public class PickableThingModel extends AbstractThingModel implements ClickableThingInterface {
	
	public PickableThingModel(int x, int y, int width, int height){
		super(x, y, width, height);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void clicked() {
		// Gå dit
		// Om kom hela vägen fram, titta på saken
		// Om bytte kurs, titta inte på saken
		// Ta bort saken
	}
}
