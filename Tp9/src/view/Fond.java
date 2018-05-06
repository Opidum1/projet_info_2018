package view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import model.Game;

public class Fond {
	
	private Game game;
	
	private static int largeur_fond = 64, hauteur_fond = 64;
	
	// NOMBRE D'ELEMENTS DANS LA MAP
	
	private int largeur, hauteur;  
	
	
	private int spawnX, spawnY;

	private int[][] terrain;
	

	
	
	public Fond(Game game, String path) {
		this.game = game;
		
		world(path);
	}
	 
	
	public void notifyView(Graphics g) {
		
		for(int y = 0; y < hauteur; y++) {
			for(int x = 0; x < largeur; x++) {
				g.drawImage(Sheets.element_Fond[terrain[x][y]],x*largeur_fond,y*hauteur_fond,largeur_fond,hauteur_fond,null);
			}
		}
		}


	private void world(String path) {
		String file = File_Reader.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		largeur = File_Reader.strToInt(tokens[0]);
		hauteur = File_Reader.strToInt(tokens[1]);
		spawnX = File_Reader.strToInt(tokens[2]);
		spawnY = File_Reader.strToInt(tokens[3]);
		
		terrain = new int [largeur][hauteur];
		System.out.println(terrain.toString());
		for(int y = 0; y < hauteur;y++ ) {
			for(int x = 0; x < largeur;x++) {
				terrain[x][y] = File_Reader.strToInt(tokens[(x + y*largeur) + 4]);
				
			}
		}
		
	}


	public BufferedImage getCarreau(int x, int y) {
		BufferedImage s = Sheets.element_Fond[terrain[x][y]];
		if(s == null)
			return Sheets.getHerbe();
		return s;
		
	}

	
	
	public  Rectangle getCollisionRec(int x, int y) {
		return new Rectangle(x/64,y/64,64,64);
	}
	
	// GET/SET

	public  int getLargeur_fond() {
		return largeur_fond;
	}





	public  int getHauteur_fond() {
		return hauteur_fond;
	}



}
