package Jeu;

import Controller.Keyboard;
import Controller.MouseManager;
import World.World;
import affichage.GameCamera;

public class Handleur {
	
	private Jeu jeu;
	private World world;
		
	public Handleur(Jeu jeu) {
		this.jeu = jeu;
	}
	
	public Jeu getJeu() {
		return jeu;
	}

	public GameCamera getGameCamera() {
		return jeu.getGameCamera();
	}
	
	public Keyboard getKeyboard() {
		return jeu.getKeyboard();
	}
	
	public MouseManager getMouseManager() {
		return jeu.getMouseManager();
	}
	
	
	public int getLargeur() {
		return jeu.getLargeur();
	}
	
	public int getHauteur() {
		return jeu.getHauteur();
	}
	
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}


	


}
