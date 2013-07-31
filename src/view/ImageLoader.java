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
			System.out.println("Den filen finns icke");
			e.printStackTrace();
			// borde st�nga ner displayen och st�nga av programmet ocks�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// borde st�nga ner displayen och st�nga av programmet ocks�
		}
		
		return texture;
	}
}
