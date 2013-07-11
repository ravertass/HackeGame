package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class ImageLoader {

	public static Texture loadTexture(String fileName) {
		Texture texture = null;
		
		try {
			texture = TextureLoader.getTexture("PNG", 
					new FileInputStream(new File("res/" + fileName + ".png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// borde stänga ner displayen och stänga av programmet också
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// borde stänga ner displayen och stänga av programmet också
		}
		
		return texture;
	}
}
