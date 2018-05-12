package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import view.Sheets;

public class Health_potion extends Objets {

	private BufferedImage im_item;
	private int  hp;
	
	public Health_potion(Game game, float posX, float posY,int hp) {
		super(game, posX, posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		this.hp = hp;
		im_item = Sheets.health_potion;
	
		ramassageRec.x = (int)(posX);
		ramassageRec.y = (int)(posY);
		ramassageRec.width = LARGEUR_OBJET;
		ramassageRec.height = HAUTEUR_OBJET;	}

//	@Override
//	public Rectangle getCollisionRec(GameObject c, float decalage_x, float decalage_y) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyView(Graphics g) {
		g.drawImage(Sheets.health_potion,(int)(posX - game.getCamera().getDecalage_x()),(int)(posY - game.getCamera().getDecalage_y()),LARGEUR_OBJET,HAUTEUR_OBJET,null);
		
	}

	@Override
	public Rectangle getCollisionRec(GameObject c,float decalage_x,float decalage_y) {
		return ramassageRec;
	}

	@Override
	public void use() {
		game.getInGame().getPlayer().addHp(hp);
		
	}

	@Override
	public BufferedImage getIm_item() {
		 return im_item;
	}

}
