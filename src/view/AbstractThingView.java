package view;

import static org.lwjgl.opengl.GL11.*;
import model.AbstractEntityModel;
import org.newdawn.slick.opengl.Texture;
import model.*;
import java.util.*;

public abstract class AbstractThingView implements ThingViewInterface {
	
	protected double x, y;
	protected int width, height;
	protected Texture texture;
	protected AbstractEntityModel model;
	protected ArrayList<String> imageList;
	
	public AbstractThingView(AbstractEntityModel model) {
		this.model = model;
		this.x = model.getX();
		this.y = model.getY();
		this.width = model.getWidth();
		this.height = model.getHeight();
		this.imageList = model.getImages();
		
		// imageList can't be empty. If so is the case, exception is thrown.
		assert imageList.isEmpty() : "Empty imageList for Model";
		
		//Sets by default the image to the first image in the imageList.
		setImage(imageList.get(0));
		
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

	public boolean shouldRemove() {
		return false;
	}
}
