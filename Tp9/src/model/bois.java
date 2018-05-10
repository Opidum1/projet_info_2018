package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import view.Sheets;

public class bois extends Objets {

	
	
	
	public bois(Game game, float posX, float posY) {
		super(game, posX, posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
	
	
		ramassageRec.x = (int)(posX);
		ramassageRec.y = (int)(posY);
		ramassageRec.width = LARGEUR_OBJET;
		ramassageRec.height = HAUTEUR_OBJET;
		
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void notifyView(Graphics g) {
		g.drawImage(Sheets.getBois(),(int)(posX - game.getCamera().getDecalage_x()),(int)(posY - game.getCamera().getDecalage_y()),LARGEUR_OBJET,HAUTEUR_OBJET,null);
		
	
	}

	@Override
	public Rectangle getCollisionRec(Creatures c, float decalage_x, float decalage_y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getCollisionRec(Objets c) {
		return ramassageRec;
	}

}
