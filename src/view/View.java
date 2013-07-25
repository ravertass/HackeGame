package view;

import java.util.ArrayList;

import model.*;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

public class View {
	
	private Texture background;
	/**private int mouseX, mouseY;
	private boolean leftClick, rightClick;**/
	private ArrayList<AbstractThingView> thingsToDraw;

	public View(Model model) {
		setupDisplay();
		setupOpenGL();
		background = ImageLoader.loadTexture("bg_chalmers");
		CursorV cursor = new CursorV(50, 50, 32, 32, model.cursor); //50, 50 is starting point for mouse TODO
		ThingView snorlax = new ThingView(128, 128, 64, 64, "snorlax_0", "snorlax_1", 
				(StateThingModel) model.thingsInRoom.get(0)); //siffrorna här borde tas
															// från snorlax-modellen på något vänster
		ThingView pokeflute = new ThingView(380, 100, 32, 32, "pokeflute", 
				(PickableThingModel) model.thingsInRoom.get(1));
		PlayerView player = new PlayerView(256, 96, 32, 64, "guybrush", model.player);
		
		InventoryView inventory = new InventoryView(0, 480, 1200, 64, "inventory", model.inventory);
		
		thingsToDraw = new ArrayList<AbstractThingView>();
		
		thingsToDraw.add(inventory);
		thingsToDraw.add(snorlax);
		thingsToDraw.add(pokeflute);
		thingsToDraw.add(player);
		thingsToDraw.add(cursor);
	}
	
	/**
	 * This method will be called by the controller class for every
	 * iteration of the main loop. It clears and renders everything to the
	 * game window.
	 */
	public void update() {
		// clear the window
		glClear(GL_COLOR_BUFFER_BIT);
		
		// draw a background
		drawBackground();
		
		// draw all game objects
		ArrayList<AbstractThingView> iterateDraw = (ArrayList<AbstractThingView>) thingsToDraw.clone();
		for (AbstractThingView thing : iterateDraw) {
			thing.draw();
			// check if a thing should be removed (for example, if it's picked up)
			boolean removeThing = thing.shouldRemove();
			if (removeThing) {
				thingsToDraw.remove(thing); 
			}
		}
		
		// update and sync display
		Display.update();
		Display.sync(60);
		
		/** reset mouse clicks
		leftClick = false;
		rightClick = false;**/
	}

	// this method will be a lot more generic when there are more rooms
	private void drawBackground() {
		background.bind();
		glBegin(GL_QUADS);
			glTexCoord2f(0, 480f/512f);
			glVertex2i(0, 0);
			glTexCoord2f(640f/1024f, 480f/512f);
			glVertex2i(640, 0);
			glTexCoord2f(640f/1024f, 0);
			glVertex2i(640, 480);
			glTexCoord2f(0, 0);
			glVertex2i(0, 480);
		glEnd();
	}

	/**
	 * This method sets up OpenGL. We're not quite sure of what it does.
	 */
	private void setupOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 0, 480, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		// Enables the use of transparent PNGs
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

	/**
	 * This method sets up and creates a new display.
	 */
	private void setupDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setFullscreen(true);
			Display.setTitle("Project Xtreme!!");
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
	}

	/**public void setMouseX(int x) {
		mouseX = x;
	}

	public void setMouseY(int y) {
		mouseY = y;
	}
	
	public void leftClick() {
		leftClick = true;
	}
	
	public void rightClick() {
		rightClick = true;
	}**/
}
