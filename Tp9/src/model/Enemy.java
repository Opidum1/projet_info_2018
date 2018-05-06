package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;




public class Enemy extends Creatures {
	
	
	public Game game;
	
	public Enemy(Game game, float posX, float posY) {
		super(game, posX, posY);
		this.posX = posX;
		this.posY = posY;
		
		 collisionRec.x = (int)(posX);
		 collisionRec.y = (int)(posY);
		 collisionRec.width = LARGEUR_CREATURE;
		 collisionRec.height = HAUTEUR_CREATURE;

	}

	



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyView(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(collisionRec.x, collisionRec.y, LARGEUR_CREATURE, HAUTEUR_CREATURE);
		
	}

	public boolean isObstacle() {
		return true;
	}

}
