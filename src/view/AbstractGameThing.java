package view;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

public abstract class AbstractGameThing implements GameThingInterface {
	
	protected int x, y, width, height;
	protected Texture texture;
	
	public AbstractGameThing(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		texture = null; //kanske måste fixa detta och se till att texture 
						//som standard är en tom bild
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setImage(String imageFileName) {
		texture = ImageLoader.loadTexture(imageFileName);
	}
	
	public void draw() {
		texture.bind();
		glBegin(GL_QUADS);
			glTexCoord2f(0, 1);
			glVertex2i(x, y);
			glTexCoord2f(1, 1);
			glVertex2i(x + width, y);
			glTexCoord2f(1, 0);
			glVertex2i(x + width, y + height);
			glTexCoord2f(0, 0);
			glVertex2i(x, y + height);
		glEnd();
	}
}
