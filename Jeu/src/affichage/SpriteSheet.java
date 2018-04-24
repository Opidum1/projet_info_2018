package affichage;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage cut(int x, int y, int largeur, int hauteur) {
		return sheet.getSubimage(x, y, largeur, hauteur);     // prends une partie de l'image
	}

}
