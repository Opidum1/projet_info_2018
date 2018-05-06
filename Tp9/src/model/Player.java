package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import view.Sheets;
import view.Window;

public class Player extends Creatures {
	
	
	//private int posX;
	//private int posY;
	public Window window;
	public Game game;
	
	
	
	public Player(Game game, float posX, float posY) {
		super(game,posX,posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		isMoving = true;
		isPlayerMovable = true;
		
		
		// GESTION DES COLLISIONS
		
		 collisionRec.x = 21;
		 collisionRec.y = 26;
		 collisionRec.width = 22;
		 collisionRec.height = 31;
		
	//	collisionRec = new Rectangle(collisionRec_x,collisionRec_y,collisionRec_width,collisionRec_height);
		

	
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void getInput() {
		xMove =0;
		yMove =0;
		
		if(isPlayerMovable) {
			if(game.getKeyboard().isHaut())
				yMove = -VITESSE_CREATURE;
			if(game.getKeyboard().isBas())
				yMove = VITESSE_CREATURE;
			if(game.getKeyboard().isGauche())
				xMove = -VITESSE_CREATURE;
			if(game.getKeyboard().isDroite())
				xMove = VITESSE_CREATURE;
		}
		}
	

	public void update() {
		System.out.println(isMoving);
		getInput();
		move();

		
		//TEST
		System.out.println(isPlayerMovable);
	}
	
	public void notifyView(Graphics g) {
		g.drawImage(Sheets.getPlayer(),(int)(posX),(int)(posY),LARGEUR_CREATURE,HAUTEUR_CREATURE,null);
		
		//TEST
		
		g.setColor(Color.BLUE);
		g.fillRect(collisionRec.x + (int)(posX), collisionRec.y + (int)(posY), collisionRec.width, collisionRec.height);
	}

}
