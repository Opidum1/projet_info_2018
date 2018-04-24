package UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class  UIObject {
	
	
	public float x,y;
	public int largeur,hauteur;
	protected Rectangle bounds;
	protected Boolean hovering = false;
	
	
	public UIObject(float x, float y, int largeur, int hauteur) {
		this.y = y;
		this.x = x;
		this.largeur = largeur;
		this.hauteur = hauteur;
		bounds = new Rectangle((int) x, (int) y, largeur,hauteur);
	}
	
	
	public abstract void update();
	
	public abstract void notifyView(Graphics g);
	
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if(bounds.contains(e.getX(), e.getY()))
			hovering = true;
		else
			hovering = false;
	
	}
	
	public void onMouseRelease(MouseEvent e) {
		if(hovering)
			onClick();
	}
	
	
	//Get/Set
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

	public Boolean getHovering() {
		return hovering;
	}

	public void setHovering(Boolean hovering) {
		this.hovering = hovering;
	}


}
