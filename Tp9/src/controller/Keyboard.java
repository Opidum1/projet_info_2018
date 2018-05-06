package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Game;

public class Keyboard implements KeyListener {
	
	
	private boolean haut,bas,gauche,droite,isPressed;
	private boolean[] touche;
	private Game game;
    
	public void update() {
		haut = touche [KeyEvent.VK_Z];
		bas = touche [KeyEvent.VK_S];
		gauche = touche [KeyEvent.VK_Q];
		droite = touche [KeyEvent.VK_D];
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		touche[e.getKeyCode()] = true;
		update();

		isPressed = true;
		System.out.println(isPressed);
	}

	public boolean isPressed() {
		return isPressed;
	}


	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		touche[e.getKeyCode()] = false;
		update();

		//System.out.println(touche[e.getKeyCode()]);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	// Get/Set
	
	public boolean isHaut() {
		return haut;
	}
	public void setHaut(boolean haut) {
		this.haut = haut;
	}
	public boolean isBas() {
		return bas;
	}
	public void setBas(boolean bas) {
		this.bas = bas;
	}
	public boolean isGauche() {
		return gauche;
	}
	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}
	public boolean isDroite() {
		return droite;
	}
	public void setDroite(boolean droite) {
		this.droite = droite;
	}
	public boolean[] getTouche() {
		return touche;
	}
	public void setTouche(boolean[] touche) {
		this.touche = touche;
	}
	public Keyboard(Game game) {
		this.game = game;
		touche = new boolean[256];
	}


}
