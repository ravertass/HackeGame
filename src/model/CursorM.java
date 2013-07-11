package model;

/**
 * @author Fabian Sörensson & Anton Bergman
 * This class handles the logic for the game cursor.
 */
public class CursorM extends AbstractThingModel {
	
	public CursorM() {
		// lol
	}

	// This method will be run by the model for every instance of the game loop
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// olololol
		// Det här måste vara här just nu, då cursor implementerar ett
		// interface som kräver den här metoden... Jag tänkte inte på det 
		// när jag ovan la till x och y som parameterar till update. Vi får
		// fundera på hur detta ska göras...
	}
}
