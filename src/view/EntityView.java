package view;

import static org.lwjgl.opengl.GL11.*;
import model.AbstractEntityModel;
import org.newdawn.slick.opengl.Texture;
import model.*;
import java.util.*;

public class EntityView {
	
	protected double x, y;
	protected int width, height;
	protected Texture texture;
	protected EntityModelInterface model;
	protected HashMap<ThingState, String> stateImageMap;
	private boolean remove;
	
	public EntityView(EntityModelInterface model) {
		this.model = model;
		this.x = model.getX();
		this.y = model.getY();
		this.width = model.getWidth();
		this.height = model.getHeight();
		this.stateImageMap = model.getImages();	
		
		// imageList can't be empty. If so is the case, exception is thrown.
		assert stateImageMap.isEmpty() : "Empty imageList for Model";
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
	
	public void update() {
		// Set the image according to the state of the model
		setImage(stateImageMap.get(model.getState()));
		
		// Fetch the coordinates from the model
		x = model.getX();
		y = model.getY();
		
		// Check if this entityview should be removed
		if (!model.exists()) {
			remove = true;
		}

		draw();
	}

	private void draw() {
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
		return remove;
	}
}
