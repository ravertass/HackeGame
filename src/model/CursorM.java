package model;

/**
 * @author Fabian S�rensson & Anton Bergman
 * This class handles the logic for the game cursor.
 */
public class CursorM extends AbstractThingModel {
	
	public CursorM() {
		super(50, 50, 32, 32);
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
		// Det h�r m�ste vara h�r just nu, d� cursor implementerar ett
		// interface som kr�ver den h�r metoden... Jag t�nkte inte p� det 
		// n�r jag ovan la till x och y som parameterar till update. Vi f�r
		// fundera p� hur detta ska g�ras...
	}
}
