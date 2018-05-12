package view;

import java.awt.image.BufferedImage;

import view.ImageLoader;
import view.SheetCut;

public class Sheets {
	
	
	
	
	private static final int largeur = 32, hauteur = 32;
	private static BufferedImage herbe,terre,bois;
	
	// PARTIE ARME
	
	public static BufferedImage wooden_sword_up, wooden_sword_down, wooden_sword_left, wooden_sword_right;
	
	public  static BufferedImage horizontale_shot;
	public  static BufferedImage vertical_shot;
	
	//PARTIE PLAYER
	
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_up;
	public static BufferedImage heart;
	
	
	// PARTIE INVENTAIRE
	
	public static BufferedImage wooden_sword_inventaire;
	public static BufferedImage health_potion;
	
	
	// LIST INTERFACE
	
	public static BufferedImage inventaire;
	public static BufferedImage selection_inventaire;
	
	
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
		

		
		// CREATION DES IMAGES DECORDS
		
		herbe = sheet.cut(0, 0, largeur, hauteur);
		
		terre = sheet.cut(largeur, 0, largeur, hauteur);
		
		// CREATION DES OBJETS
		
		wooden_sword_up = sheet.cut(largeur *7, hauteur, largeur, hauteur);
		wooden_sword_down = sheet.cut(0, hauteur *2, largeur, hauteur);
		wooden_sword_left = sheet.cut(largeur, hauteur *2, largeur, hauteur);
		wooden_sword_left = sheet.cut(largeur *3, hauteur *2, largeur, hauteur);
		
		health_potion = sheet.cut(largeur *6, hauteur *2, largeur, hauteur);
		
		bois = sheet.cut(largeur *5, hauteur, largeur, hauteur);
		
		horizontale_shot = sheet.cut(0,hauteur*3,largeur,hauteur);
		vertical_shot = sheet.cut(largeur, hauteur *3, largeur, hauteur);
		// CREATION INVENTAIRE 
		
		inventaire = sheet.cut(largeur *3, hauteur*4 - 1, (largeur * 3) + 8, (hauteur * 3) + 8);
		selection_inventaire = sheet.cut(largeur *6, hauteur, largeur, hauteur);
		
		//LIST DES OBJETS
		
		element_objet = new BufferedImage[256];
		element_objet[0] = bois;
		
		// LIST DES DECORD
		
		element_Fond = new BufferedImage[256];
		element_Fond[0] = herbe;
		element_Fond[1] = terre;
	
		// CREATION INVENTAIRE
		
		wooden_sword_inventaire = sheet.cut(largeur *5, hauteur *2, largeur, hauteur);
		
		
		//DOWN
		player_down = new BufferedImage[2];
		player_down[0] = sheet.cut(largeur * 2, 0, largeur, hauteur);
		player_down[1] = sheet.cut(largeur * 3, 0, largeur, hauteur);
		
		//UP
		player_up = new BufferedImage[2];
		player_up[0] = sheet.cut(largeur * 4, 0, largeur, hauteur);
		player_up[1] = sheet.cut(largeur * 5, 0, largeur, hauteur);
		
		
		//LEFT
		player_left = new BufferedImage[2];
		player_left[0] = sheet.cut(largeur * 6, 0, largeur, hauteur);
		player_left[1] = sheet.cut(largeur * 7, 0, largeur, hauteur);
		
		//RIGHT
		player_right = new BufferedImage[2];
		player_right[0] = sheet.cut(0, hauteur, largeur, hauteur);
		player_right[1] = sheet.cut(largeur, hauteur, largeur, hauteur);
		
	
		heart = sheet.cut(largeur * 7, hauteur *2, largeur, hauteur);
		
	}

	public static BufferedImage getSelection_inventaire() {
		return selection_inventaire;
	}

	public static void setSelection_inventaire(BufferedImage selection_inventaire) {
		Sheets.selection_inventaire = selection_inventaire;
	}

	public static BufferedImage getInventaire() {
		return inventaire;
	}

	public static void setInventaire(BufferedImage inventaire) {
		Sheets.inventaire = inventaire;
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




	public static BufferedImage getWooden_sword_up() {
		return wooden_sword_up;
	}

	public static void setWooden_sword_up(BufferedImage wooden_sword_up) {
		Sheets.wooden_sword_up = wooden_sword_up;
	}

	public static BufferedImage getWooden_sword_down() {
		return wooden_sword_down;
	}

	public static void setWooden_sword_down(BufferedImage wooden_sword_down) {
		Sheets.wooden_sword_down = wooden_sword_down;
	}

	public static BufferedImage getWooden_sword_left() {
		return wooden_sword_left;
	}

	public static void setWooden_sword_left(BufferedImage wooden_sword_left) {
		Sheets.wooden_sword_left = wooden_sword_left;
	}

	public static BufferedImage getWooden_sword_right() {
		return wooden_sword_right;
	}

	public static void setWooden_sword_right(BufferedImage wooden_sword_right) {
		Sheets.wooden_sword_right = wooden_sword_right;
	}

	public static void setHerbe(BufferedImage herbe) {
		Sheets.herbe = herbe;
	}




	public static BufferedImage getTerre() {
		return terre;
	}

	public static void setTerre(BufferedImage terre) {
		Sheets.terre = terre;
	}

}
