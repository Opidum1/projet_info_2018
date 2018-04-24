package affichage;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));  // return le buffer object de notre image
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);   // si l'image ne charge pas, on ne veut pas lancer le jeu
		}
		return null;
	}

}
