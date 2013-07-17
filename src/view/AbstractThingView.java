package view;

import static org.lwjgl.opengl.GL11.*;

import model.AbstractThingModel;
import model.ThingModelInterface;

import org.newdawn.slick.opengl.Texture;

public abstract class AbstractThingView implements ThingViewInterface {
	
	protected int x, y, width, height;
	protected Texture texture;
	protected ThingModelInterface model;
	
	public AbstractThingView(int x, int y, int width, int height, String imageName, AbstractThingModel model) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setImage(imageName);
		this.model = model;
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
