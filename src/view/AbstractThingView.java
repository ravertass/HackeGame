package view;

import static org.lwjgl.opengl.GL11.*;

import model.AbstractThingModel;

import org.newdawn.slick.opengl.Texture;

public abstract class AbstractThingView implements ThingViewInterface {
	
	protected double x, y;
	protected int width, height;
	protected Texture texture;
	protected AbstractThingModel model;
	
	public AbstractThingView(double x, double y, int width, int height, String imageName, 
			AbstractThingModel model) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setImage(imageName);
		this.model = model;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void setImage(String imageFileName) {
		texture = ImageLoader.loadTexture(imageFileName);
	}
	
	public void draw() {
		texture.bind();
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2d(x, y);
			glTexCoord2f(1, 0);
			glVertex2d(x + width, y);
			glTexCoord2f(1, 1);
			glVertex2d(x + width, y - height);
			glTexCoord2f(0, 1);
			glVertex2d(x, y - height);
		glEnd();
	}
}
