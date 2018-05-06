package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import view.Fond;
import view.Sheets;

public abstract class Creatures {
	
	
	
	// STATS DE BASE 
	
	public static final int LARGEUR_CREATURE = 64 ,HAUTEUR_CREATURE = 64;
	public static final int HP_CREATURE = 5;
	public static final float  VITESSE_CREATURE = 3;
	
	
	// STAT ET BUFFS
	
	protected boolean isPlayerMovable;
	
	
	protected Game game;
	
	protected float xMove,yMove,posX,posY;
	
	protected Rectangle collisionRec;
	
	protected boolean isMoving = false;
	

	

	
	
	
	public Creatures(Game game, float posX, float posY) {
		this.posX =posX;
		this.posY =posY;
		this.game = game;
		xMove= 0;
		yMove= 0;
		
		collisionRec = new Rectangle(0,0,LARGEUR_CREATURE,HAUTEUR_CREATURE);

	}
	
	
	public void move() {
		
		if(xMove !=0 && !CollisionPnj(xMove,0f))
			moveX();
			
		if(yMove !=0 && !CollisionPnj(0f,yMove))
			moveY();
	}
	
	
	
	// LES METHODES moveX(Y) VERIFIENT LES 4 COINS POUR VOIR SI IL Y A COLLISION OU PAS
	
	
	public void moveX(){  
		
		if(xMove > 0) {  // DEPLACEMENT DROITE 
			if(!CollisionObstacle((int) (posX + collisionRec.x + collisionRec.width + xMove), (int) (posY + collisionRec.y)) 
					&& !CollisionObstacle((int) (posX + collisionRec.x + collisionRec.width + xMove), (int)(posY + collisionRec.y + collisionRec.height )) ) {
				posX += xMove;
			}
			}
		else if(xMove < 0) { // DEPLACEMENT GAUCHE
			if(!CollisionObstacle((int)(posX + collisionRec.x + xMove),(int)(posY + collisionRec.y ))
					&& !CollisionObstacle((int)(posX + collisionRec.x + xMove),(int)(posY + collisionRec.y + collisionRec.height))) {
				posX += xMove;	
	}
		
		
		}
		
		}



	public void moveY() {
			
		if(yMove < 0) { //DEPLACEMENT HAUT
			if(!CollisionObstacle((int)(posX + collisionRec.x),(int)(posY + collisionRec.y + yMove))
					&& !CollisionObstacle((int)(posX + collisionRec.x + collisionRec.width),(int)(posY + collisionRec.y + yMove))) {
				posY += yMove;
			}
		}else if(yMove > 0) {
			if(!CollisionObstacle((int)(posX + collisionRec.x),(int)(posY + collisionRec.y + collisionRec.height + yMove)) 
					&& !CollisionObstacle((int)(posX + collisionRec.x + collisionRec.width),(int)(posY + collisionRec.y + collisionRec.height + yMove))) {
				posY += yMove;
			}
			
		}
	}


	// GESTION COLLISION
	
	
 
	
	public Rectangle getCollisionRec(Creatures c,float decalage_x,float decalage_y) {
		if(c.isMoving) {
			return new Rectangle(collisionRec.x + (int) (posX) + (int) (decalage_x), collisionRec.y + (int)(posY) + (int) (decalage_y), collisionRec.width,collisionRec.height);
		}
		else {
			return c.collisionRec;
		}
	}


	private boolean CollisionPnj(float decalage_x,float decalage_y) {
		 boolean isCollision = false;
		for(Creatures c: game.getPnjList().getPnj()) {
			if(c.equals(this))                             //Pour ne pas bloquer quand le for arrive sur l'objet même
				continue;
			if(this.getCollisionRec(this,decalage_x,decalage_y).intersects(c.getCollisionRec(c,decalage_x,decalage_y))) {
				isCollision = true;
			}
		}
			return isCollision;
	}
	
	
	public boolean CollisionObstacle(int x, int y) {
		return  Sheets.isObstacle(game.getFond().getCarreau(x/64, y/64));
	}
	
	// Collision avec l'environnment en cours de codage
	
	
	
	
	
	// ABSTRACT METHODE
	
	public abstract void update();
	public abstract void notifyView(Graphics g);
	
	
	
	// BUFF ET STATS
	

	
	// GET/SET
	
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


}
