package view;

import java.awt.image.BufferedImage;

// Permet de découper le sprite qu'on a besoins dans la sprite sheet

public class SheetCut {
	
	private BufferedImage sheet;
	
	public SheetCut(BufferedImage sheet) {
		this.sheet = sheet;
	}

	public BufferedImage cut(int x, int y, int largeur, int hauteur) {
		return sheet.getSubimage(x, y, largeur, hauteur); 
	}
	
}
