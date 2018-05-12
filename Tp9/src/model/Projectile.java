package model;

import java.awt.Graphics;
import java.awt.Rectangle;

import view.Sheets;




public class Projectile extends Creatures {
	
	private long lastTime;
	private long timer;
	
	
	private int dmg;
	private int direction;
	
	public Projectile(Game game, float posX, float posY,int dmg,int direction) {
		super(game,posX,posY);
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		this.dmg = dmg;
		this.direction = direction;
		isMoving = true;
		isProjectile = true;
		
		collisionRec.x =1;
		collisionRec.y = 8;
		collisionRec.width =20;
		collisionRec.height =10;
		
	
		lastTime = System.currentTimeMillis();
	
	}

	
	
	

	
	@Override
	public Rectangle getCollisionRec(GameObject c, float decalage_x, float decalage_y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		timer += System.currentTimeMillis() - lastTime;   // nous donne le temps passé avant entre le dernier update et maintenant
		lastTime = System.currentTimeMillis();
		
		if(timer < 2000) {
			
		}else {
			mort();
		}
		
		if(direction == 1) {
			yMove = -2*VITESSE_CREATURE;
		}
		if(direction == 2) {
			xMove = 2*VITESSE_CREATURE;
		}
		if(direction == 3) {
			yMove = 2*VITESSE_CREATURE;
		}
		if(direction == 4) {
			xMove = -2*VITESSE_CREATURE;
		}
		move();
		



	}

	@Override
	public void notifyView(Graphics g) {
		
		if(direction ==2 || direction == 4) {
			collisionRec.x =1;
			collisionRec.y = 8;
			collisionRec.width =20;
			collisionRec.height =10;
			g.drawImage(Sheets.horizontale_shot,(int)(posX - game.getCamera().getDecalage_x()),(int) (posY - game.getCamera().getDecalage_y()),32,32,null);
		}else if(direction == 1 || direction == 3) {
		collisionRec.x =11;
		collisionRec.y = 5;
		collisionRec.width =10;
		collisionRec.height =20;
		g.drawImage(Sheets.vertical_shot,(int)(posX - game.getCamera().getDecalage_x()),(int) (posY - game.getCamera().getDecalage_y()), 32, 32,null);

		
		}
	}

	
	public void move() {
		
		if(xMove !=0 && !CollisionPnj(xMove,0f))
			moveX();
			
		if(yMove !=0 && !CollisionPnj(0f,yMove))
			moveY();
	}
	
	
	public void moveX(){  
		
		if(xMove > 0) {  // DEPLACEMENT DROITE 
			if(!CollisionObstacle((int) (posX + collisionRec.x + collisionRec.width + xMove), (int) (posY + collisionRec.y)) 
					&& !CollisionObstacle((int) (posX + collisionRec.x + collisionRec.width + xMove), (int)(posY + collisionRec.y + collisionRec.height )) ) {
				posX += xMove;
			}else {
				mort();
			}
			}
		else if(xMove < 0) { // DEPLACEMENT GAUCHE
			if(!CollisionObstacle((int)(posX + collisionRec.x + xMove),(int)(posY + collisionRec.y ))
					&& !CollisionObstacle((int)(posX + collisionRec.x + xMove),(int)(posY + collisionRec.y + collisionRec.height))) {
				posX += xMove;	
	}else {
		mort();
	}
		}
		
		}



	public void moveY() {
			
		if(yMove < 0) { //DEPLACEMENT HAUT
			if(!CollisionObstacle((int)(posX + collisionRec.x),(int)(posY + collisionRec.y + yMove))
					&& !CollisionObstacle((int)(posX + collisionRec.x + collisionRec.width),(int)(posY + collisionRec.y + yMove))) {
				posY += yMove;
			}else {
				mort();
			}
		}else if(yMove > 0) {
			if(!CollisionObstacle((int)(posX + collisionRec.x),(int)(posY + collisionRec.y + collisionRec.height + yMove)) 
					&& !CollisionObstacle((int)(posX + collisionRec.x + collisionRec.width),(int)(posY + collisionRec.y + collisionRec.height + yMove))) {
				posY += yMove;
			}else {
				mort();
			}
			
		}
	}
	
	
	
	private boolean CollisionPnj(float decalage_x,float decalage_y) {
		 boolean isCollision = false;
		for(Creatures c: game.getInGame().getPnjList().getPnj()) {
			if(c.equals(this))                             //Pour ne pas bloquer quand le for arrive sur l'objet même
				continue;
			if(this.getCollisionRec(this,decalage_x,decalage_y).intersects(c.getCollisionRec(c,decalage_x,decalage_y))) {
				if(c == game.getInGame().getPlayer()) {
					isCollision = false;
				}else {
				mort();
				c.degat(dmg);
				isCollision = true;
			
				
				}}

		
		}
			return isCollision;
	}
	
	
	@Override
	public void mort() {
		
		
		
		vivant = false;
		
	}

	@Override
	public void dmgAnim() {
		// TODO Auto-generated method stub
		
	}

}
