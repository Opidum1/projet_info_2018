package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import view.Sheets;

public class bois extends Objets {

	
	private BufferedImage im_item;
	
	public bois(Game game, float posX, float posY) {
		super(game, posX, posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		im_item = Sheets.getBois();
	
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
	public Rectangle getCollisionRec(GameObject c, float decalage_x, float decalage_y) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Rectangle getCollisionRec(Objets c) {
//		return ramassageRec;
//	}

	@Override
	public BufferedImage getIm_item() {
		return im_item;
		
	}


	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}




}
