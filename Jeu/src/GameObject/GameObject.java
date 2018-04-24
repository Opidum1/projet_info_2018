package GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import Jeu.Handleur;

public abstract class GameObject {
	
	protected float x, y;
	protected int largeur, hauteur;
	protected Handleur handler;
	protected Rectangle bounds;
	
	public GameObject(Handleur handler, float x, float y, int largeur, int hauteur) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		
		bounds = new Rectangle(0,0, largeur, hauteur);
	}
	

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(GameObject e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))	
				return true;
		}
		return false;
	}
	
	public float getX() {
		return x;
	
	}

	public void setX(float x) {
		this.x = x;
	}






	public float getY() {
		return y;
	}






	public void setY(float y) {
		this.y = y;
	}






	public int getLargeur() {
		return largeur;
	}






	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}






	public int getHauteur() {
		return hauteur;
	}






	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}






	public abstract void update();
	
	public abstract void notifyView(Graphics g);
	

}
