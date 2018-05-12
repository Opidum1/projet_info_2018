package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Objets implements GameObject {

	protected Game game;
	
	// STATS DE BASE
	
	 public static final int LARGEUR_OBJET = 32 ,HAUTEUR_OBJET = 32;
	
	 
	// STATS RELATIVES A CHAQUE OBJET
	 
	 protected boolean existant = true;  // PERMET DE SAVOIR SI L'OBJET EST RAMMASE OU NON
	 protected float posX,posY;
	 protected int nombre;
	 
	 
	 protected Rectangle ramassageRec;
	 
	protected int type;
	 
	 public Objets(Game game, float posX, float posY) {
		 this.game = game;
		 this.posX = posX;
		 this.posY = posY;
	
		 ramassageRec = new Rectangle(0,0,LARGEUR_OBJET,HAUTEUR_OBJET);  // CREE UN RECTANGLE DE RAMASSAGE POUR CHAQUE OBJET
	 }
	 
	 
	 public void ramassé() {
		
		 existant = false;
		
		 // TEST
		 System.out.println(existant);
		 
		 // A CODER QUAND L'INVENTAIRE SERA FAIT 
	 }
	 
	public float getPosX() {
		return posX;
	}


	public void setPosX(float posX) {
		this.posX = posX;
	}


	public float getPosY() {
		return posY;
	}


	public void setPosY(float posY) {
		this.posY = posY;
	}

	



	@Override
	public abstract void update();


	@Override
	public abstract void notifyView(Graphics g); 


	@Override
	public abstract Rectangle getCollisionRec(GameObject c,float decalage_x,float decalage_y);


	public abstract void use();
	
	public abstract BufferedImage getIm_item();




	

}
