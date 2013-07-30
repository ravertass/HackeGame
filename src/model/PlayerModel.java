package model;

public class PlayerModel extends AbstractEntityModel implements ThingModelInterface {
	
	private final double walkingSpeed = .11;
	private double destinationX;
	private double destinationY;
	private boolean walking; 
	private InteractableInterface targetThing;
	
	public PlayerModel(double x, double y, int width, int height) {
		super(x, y, width, height);
		// olol
		destinationX = 0;
		destinationY = 0;
		walking = false;
		targetThing = null;
	}
	
	public Event update(int mouseX, int mouseY, boolean leftClick, int delta, 
			InteractableInterface targetThing) {
		
		Event event = null;
		
		if (leftClick) {
			destinationX = mouseX;
			destinationY = mouseY;
			walking = true;
			
			this.targetThing = targetThing;
		}
		
		if (walking) {
			// Calculate where the player actually stands, not where he is drawn
			double standX = x + (width / 2);
			double standY = y - height;
			
			double distanceX = destinationX - standX;
			double distanceY = destinationY - standY;
			
			double walkingProp = walkingSpeed / 
					Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
			
			double dX = walkingProp * distanceX;
			double dY = walkingProp * distanceY;
			
			x += dX * delta;
			y += dY * delta;
			
			// Han hamnar aldrig exakt där man vill... men det fungerar någorlunda bra
			// Så som det är nu så är det fel: om frameraten skulle vara högre så skulle
			// han hamna på fel ställe.
			if ((standX < destinationX + 1 && standX > destinationX - 1) && 
					(standY < destinationY + 1 && standY > destinationY - 1)) {
				walking = false;
				if (this.targetThing != null) {
					event =	this.targetThing.clicked();	
				}
			}
		}
		return event;
	}
}
