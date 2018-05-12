package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Game;

public class Keyboard implements KeyListener {
	
	// INVENTAIRE
	
	private boolean inventaire;
	private boolean inventaire1;
	private boolean inventaire2;
	private boolean inventaire3;
	
	private boolean utiliser;
	//DEPLACEMENT
	
	private boolean haut,bas,gauche,droite,isPressed;
	
	//COMBAT
	
	private boolean attaque_haut,attaque_bas,attaque_gauche,attaque_droite;
	
	private boolean space = false;
	private boolean[] touche;
	private Game game;
    
	public void update() {
		
		// DEPLACEMENT
		
		haut = touche [KeyEvent.VK_Z];
		bas = touche [KeyEvent.VK_S];
		gauche = touche [KeyEvent.VK_Q];
		droite = touche [KeyEvent.VK_D];
		
		//INVENTAIRE
		
		inventaire = touche [KeyEvent.VK_I];
		
		inventaire1 = touche [KeyEvent.VK_1];
		inventaire2 = touche [KeyEvent.VK_2];
		inventaire3 =  touche [KeyEvent.VK_3];
		
		utiliser = touche [KeyEvent.VK_ENTER];
		
		space = touche [KeyEvent.VK_SPACE];
		
		// COMBAT
		
		attaque_haut = touche [KeyEvent.VK_UP];
		attaque_bas = touche [KeyEvent.VK_DOWN];
		attaque_gauche = touche [KeyEvent.VK_LEFT];
		attaque_droite = touche [KeyEvent.VK_RIGHT];
		
	}
	
	
	public boolean isUtiliser() {
		return utiliser;
	}


	public void setUtiliser(boolean use) {
		this.utiliser = use;
	}


	public boolean isInventaire1() {
		return inventaire1;
	}


	public void setInventaire1(boolean inventaire1) {
		this.inventaire1 = inventaire1;
	}


	public boolean isInventaire2() {
		return inventaire2;
	}


	public void setInventaire2(boolean inventaire2) {
		this.inventaire2 = inventaire2;
	}


	public boolean isInventaire3() {
		return inventaire3;
	}


	public void setInventaire3(boolean inventaire3) {
		this.inventaire3 = inventaire3;
	}


	public boolean isInventaire() {
		return inventaire;
	}


	public void setInventaire(boolean inventaire) {
		this.inventaire = inventaire;
	}


	public boolean isSpace() {
		return space;
	}


	public void setSpace(boolean space) {
		this.space = space;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		// 1 ER PARTIE TU IF GERE LA TOUCHE ESPACE 
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(touche[KeyEvent.VK_SPACE] == true) {
				touche[KeyEvent.VK_SPACE] = false;
			}else if(touche[KeyEvent.VK_SPACE] == false) {
				touche[KeyEvent.VK_SPACE] = true;
			}
		}else 	if(e.getKeyCode() == KeyEvent.VK_I) {
			if(touche[KeyEvent.VK_I] == true) {
				touche[KeyEvent.VK_I] = false;
			}else if(touche[KeyEvent.VK_I] == false) {
				touche[KeyEvent.VK_I] = true;
			}
		}else {
			touche[e.getKeyCode()] = true;
		}
		
		update();

		isPressed = true;

		// TEST
		
		//System.out.println(isPressed);
	}

	public boolean isPressed() {
		return isPressed;
	}


	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		// 1 ER PARTIE DU IF GERE LA TOUCHE ESPACE
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_I) {
			
		}else {
			touche[e.getKeyCode()] = false;
		}
		update();

		// TEST
		
			//System.out.println(touche[e.getKeyCode()]);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	// Get/Set
	
	
	
	public boolean isHaut() {
		return haut;
	}
	public boolean isAttaque_haut() {
		return attaque_haut;
	}


	public void setAttaque_haut(boolean attaque_haut) {
		this.attaque_haut = attaque_haut;
	}


	public boolean isAttaque_bas() {
		return attaque_bas;
	}


	public void setAttaque_bas(boolean attaque_bas) {
		this.attaque_bas = attaque_bas;
	}


	public boolean isAttaque_gauche() {
		return attaque_gauche;
	}


	public void setAttaque_gauche(boolean attaque_gauche) {
		this.attaque_gauche = attaque_gauche;
	}


	public boolean isAttaque_droite() {
		return attaque_droite;
	}


	public void setAttaque_droite(boolean attaque_droite) {
		this.attaque_droite = attaque_droite;
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
