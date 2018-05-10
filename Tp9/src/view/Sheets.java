package view;

import java.awt.image.BufferedImage;

import view.ImageLoader;
import view.SheetCut;

public class Sheets {
	
	
	private static final int largeur = 32, hauteur = 32;
	private static BufferedImage player,herbe,terre,bois;
	
	// LIST DES DECORDS
	
	public static BufferedImage[] element_Fond;
	
	// LIST DES OBJETS
	
	public static BufferedImage[] element_objet;
	
	
	public static BufferedImage getBois() {
		return bois;
	}

	public static void setBois(BufferedImage bois) {
		Sheets.bois = bois;
	}

	public static void Init() {
		SheetCut sheet =  new SheetCut(ImageLoader.loadImage("/textures/sprite_sheet_gd.png"));
		
		// CREATION DES IMAGES JOUEURS
		
		player = sheet.cut(largeur * 2, 0, largeur, hauteur);
		
		// CREATION DES IMAGES DECORDS
		
		herbe = sheet.cut(0, 0, largeur, hauteur);
		
		terre = sheet.cut(largeur, 0, largeur, hauteur);
		
		// CREATION DES OBJETS
		
		bois = sheet.cut(largeur *5, hauteur, largeur, hauteur);
		
		
		//LIST DES OBJETS
		
		element_objet = new BufferedImage[256];
		element_objet[0] = bois;
		
		// LIST DES DECORD
		
		element_Fond = new BufferedImage[256];
		element_Fond[0] = herbe;
		element_Fond[1] = terre;
	
	
	}

	public static boolean isObstacle(BufferedImage im) {
		if(im.equals(terre))
			return true;
		else 
			return false;
	}
	
	// GET/SET
	
	
	public static BufferedImage getHerbe() {
		return herbe;
	}


	public static void setHerbe(BufferedImage herbe) {
		Sheets.herbe = herbe;
	}


	public static BufferedImage getPlayer() {
		return player;
	}


	public static void setPlayer(BufferedImage player) {
		Sheets.player = player;
	}

	public static BufferedImage getTerre() {
		return terre;
	}

	public static void setTerre(BufferedImage terre) {
		Sheets.terre = terre;
	}

}
