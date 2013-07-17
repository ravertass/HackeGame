package model;

public class PlayerModel extends AbstractThingModel implements ThingModelInterface {
	
	private final int walkingSpeed = 2;
	private int destinationX;
	private int destinationY;
	private boolean walking; 
	
	public PlayerModel(int x, int y, int width, int height) {
		super(x, y, width, height);
		// olol
		destinationX = 0;
		destinationY = 0;
		walking = false;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void update() {
		// lol
	}
	
	public void update(int mouseX, int mouseY, boolean rightClick) {
		if (rightClick) {
			destinationX = mouseX;
			destinationY = mouseY;
			walking = true;
		}
		
		if (walking) {
			// Calculate where the player actually stands, not where he is drawn
			int standX = x + (width / 2);
			int standY = y - height;
			
			int distanceX = destinationX - standX;
			int distanceY = destinationY - standY;
			
			double walkingProp = walkingSpeed / 
					Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
			
			int dX = Math.round(walkingSpeed * distanceX);
			int dY = Math.round(walkingSpeed * distanceY);
			
			x += dX;
			y += dY;
			
			if (x == destinationX && y == destinationY) {
				walking = false;
			}
		}
	}
}
