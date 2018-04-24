	package GameObject;

import Jeu.Handleur;
import tiles.Tile;

public abstract class Creatures extends GameObject {
	
	public static final int DEFAULT_HP = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_LARGEUR = 64,
							DEFAULT_CREATURE_HAUTEUR = 64;
	
	
	protected int hp;
	protected float speed;
	protected float xMove, yMove;

	public Creatures(Handleur handler, float x, float y, int largeur, int hauteur) {
		super(handler, x , y, largeur, hauteur);
		hp = DEFAULT_HP;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
		
	}
	
	public void moveX() {
		if (xMove > 0) { //Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_LARGEUR;
			
			if(!CollisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HAUTEUR) &&
			!CollisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HAUTEUR)){
				x += xMove;
			}else {
				x = tx * Tile.TILE_LARGEUR - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0) {// Moving left
					int tx = (int) (x + xMove + bounds.x ) / Tile.TILE_LARGEUR;
		
		if(!CollisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HAUTEUR) &&
		!CollisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HAUTEUR)){
			x += xMove;
		}else {
			x = tx * Tile.TILE_LARGEUR + Tile.TILE_LARGEUR - bounds.x;
		}

		}
		
		
	}
	
	public void moveY() {
		
		// on regarde les 4 coins du rectangle de détection pour vérifier si il y a collision ou pas !
		
		if(yMove < 0) { //Moving up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HAUTEUR;
		
			if(!CollisionWithTile((int) (x + bounds.x) / Tile.TILE_LARGEUR, ty) && 
					!CollisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_LARGEUR, ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILE_HAUTEUR + Tile.TILE_HAUTEUR - bounds.y;
			}
		}else if (yMove > 0) { // Moving down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HAUTEUR;
		
			if(!CollisionWithTile((int) (x + bounds.x) / Tile.TILE_LARGEUR, ty) && 
					!CollisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_LARGEUR, ty)) {
				y += yMove;

			}else {
				y = ty * Tile.TILE_HAUTEUR -bounds.y - bounds.height - 1;
			}
		}
	}
	
	
	protected boolean CollisionWithTile(int x , int y) {
		return handler.getWorld().getTile(x, y).isObstacle();
	}
	// GET/SET

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	

}
